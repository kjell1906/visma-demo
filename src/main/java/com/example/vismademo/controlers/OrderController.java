package com.example.vismademo.controlers;

import com.example.vismademo.entities.Cart;
import com.example.vismademo.entities.Item;
import com.example.vismademo.entities.OrderLine;
import com.example.vismademo.repositories.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class OrderController {


    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;
    private final ItemRepository itemRepository;
    private final DiscountRepository discountRepository;
    private final MemberRepository memberRepository;


    public OrderController(
            OrderRepository orderRepository,
            OrderLineRepository orderLineRepository,
            ItemRepository itemRepository,
            DiscountRepository discountRepository,
            MemberRepository memberRepository) {


        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
        this.itemRepository = itemRepository;
        this.discountRepository = discountRepository;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/")
    public String usage(){
        return "use /get_order to get order details and /create_order to create new.";
    }

    record OrderLineDTO (String product, String discount) {}
    @GetMapping("/get_order")
    public List<OrderLineDTO> getOrder(@RequestParam Integer id){

        List<OrderLineDTO> dtos = new ArrayList<>();

        try {
            Optional<Cart> cart = orderRepository.findById(id);
            if(cart.isPresent()){
                for (OrderLine l: cart.get().getOrderLine()) {
                    OrderLineDTO dto = new OrderLineDTO(l.getItem().getDescription(), l.getDiscount().getName());
                    dtos.add(dto);
                }

                return dtos;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    record OrderlineRequest(
            String flavor,
            String itemNumber){

    }

    @PostMapping("/create_order")
    public String createOrder(@RequestBody OrderlineRequest[] orderlineRequest){
        Cart cart = new Cart();
        cart.setOrderDate(new Date());
//        orderRepository.save(cart);

        for (OrderlineRequest r: orderlineRequest
        ) {
            Item item = null;
            if(!r.itemNumber.isBlank()){
                // Look for items by item number
                item = itemRepository.findItemByItemNumber(r.itemNumber);
                System.out.println(item.getDescription());
            }
            else {
                // Look for items by flavor
                item = itemRepository.findItemByFlavor(r.flavor);
                System.out.println(item.getDescription());
            }

//            OrderLine orderLine = new OrderLine();
//            cart.getOrderLine().add(orderLine);
        }

        return "Create Order";
    }
}
