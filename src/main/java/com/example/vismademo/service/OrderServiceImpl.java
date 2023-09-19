package com.example.vismademo.service;

import com.example.vismademo.controlers.OrderController;
import com.example.vismademo.dtos.CartDTO;
import com.example.vismademo.dtos.OrderLineDTO;
import com.example.vismademo.dtos.OrderlineRequestDTO;
import com.example.vismademo.entities.*;
import com.example.vismademo.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Using service to make the service loose coupled.
 * This gives us the option to use Service Layer in other services or controllers with just calling the service method to
 * get data from logic. We also hold the logic in methods in service class and have achieved code reuse and only one place to update the code.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private OrderLineService orderLineService;
    private ItemService itemService;
    private MemberService memberService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderLineService orderLineService,
                            ItemService itemService,
                            MemberService memberService) {
        this.orderRepository = orderRepository;
        this.orderLineService = orderLineService;
        this.itemService = itemService;
        this.memberService = memberService;
    }

    @Override
    public String createOrder(OrderlineRequestDTO[] orderlineRequestDTOS) {

        // Create Cart / Order
        Cart cart = new Cart();
        cart.setOrderDate(new Date());
        orderRepository.save(cart);

        // Bring in data from RequestBody
        for (OrderlineRequestDTO requestDTO: orderlineRequestDTOS
        ) {
            Item item = null;

            // Check if itemNumber exists, query for item by item_number
            if(!requestDTO.getItemNumber().isBlank()){
                // Look for items by item number
                item = itemService.findItemByItemNumber(requestDTO.getItemNumber());

                System.out.println(item.getDescription());

            }

            // Check if itemNumber exists, if not exists query by flavor
            else {
                // Look for items by flavor
                item = itemService.findItemByFlavor(requestDTO.getFlavor());
                System.out.println(item.getDescription());
            }

            List<Discount> discounts = null;

            // Check if memberId exists, if so, get member and check if they have discounts
            if(requestDTO.getMemberId() != null){
                Member member = memberService.findMemberById(requestDTO.getMemberId());

                if(member != null){
                    discounts = member.getDiscount();
                }
            }

            // Create orderline
            OrderLine orderLine = new OrderLine();
            orderLine.setItem(item);
            for (Discount d: discounts) {
                if(d.getItem().getId().equals(item.getId())){
                    orderLine.setDiscount(d);
                }
            }

            orderLine.setOrder(cart);
            orderLine.setQuantity(1);

            Integer calculateDiscount = 0;

            if(discounts.size() > 0){
                if(orderLine.getDiscount() != null)
                    calculateDiscount = item.getPrice() * orderLine.getDiscount().getPercentage() / 100;
            }

            Integer amount = (item.getPrice() - calculateDiscount) * orderLine.getQuantity();
            orderLine.setLineAmount(amount);

            // Add latest orderline into cart orderlines
            cart.getOrderLine().add(orderLine);
        }

        // Store orderline
        orderLineService.save( cart.getOrderLine());
        return "Order Created";
    }

    @Override
    public CartDTO getOrder(int id) {

        try {
            Optional<Cart> cart = orderRepository.findById(id);
            if(cart.isPresent()){
                CartDTO cartDTO = new CartDTO();

                cartDTO.setId(cart.get().getId());
                cartDTO.setOrderDate(cart.get().getOrderDate());

                for (OrderLine l: cart.get().getOrderLine()) {

                    OrderLineDTO dto = new OrderLineDTO();
                    dto.setItemNumber(l.getItem().getItemNumber());
                    dto.setProduct(l.getItem().getDescription());
                    if (l.getDiscount() != null) {
                        dto.setDiscount(l.getDiscount().getName());
                        dto.setPercentage(l.getDiscount().getPercentage());
                    } else {
                        dto.setDiscount("");
                    }
                    cartDTO.getOrderLines().add(dto);
                }

                return cartDTO;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
