package com.example.vismademo.service;

import com.example.vismademo.entities.Item;
import com.example.vismademo.repositories.ItemRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
/**
 * Using service to make the service loose coupled.
 * This gives us the option to use Service Layer in other services or controllers with just calling the service method to
 * get data from logic. We also hold the logic in methods in service class and have achieved code reuse and only one place to update the code.
 */
@Service
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public Item findItemByItemNumber(String itemNumber) {
        return itemRepository.findItemByItemNumber(itemNumber);
    }

    @Override
    public Item findItemByFlavor(String flavor) {
        return itemRepository.findItemByFlavor(flavor);
    }


}
