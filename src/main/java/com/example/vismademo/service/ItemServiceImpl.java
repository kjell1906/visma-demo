package com.example.vismademo.service;

import com.example.vismademo.entities.Item;
import com.example.vismademo.repositories.ItemRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

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
