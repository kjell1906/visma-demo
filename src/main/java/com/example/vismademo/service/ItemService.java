package com.example.vismademo.service;

import com.example.vismademo.entities.Item;
import com.example.vismademo.repositories.ItemRepository;

public interface ItemService {

    Item findItemByItemNumber(String itemNumber);

    Item findItemByFlavor(String flavor);
}
