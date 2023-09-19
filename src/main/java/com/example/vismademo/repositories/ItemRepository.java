package com.example.vismademo.repositories;

import com.example.vismademo.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository  extends JpaRepository<Item, Integer> {

    // Created custom query to lookup item by flavor
    @Query("FROM Item WHERE flavor = :flavor")
    Item findItemByFlavor(@Param("flavor") String flavor);

    // Created custom query to lookup item by itemNumber
    @Query("FROM Item WHERE itemNumber = :itemNumber")
    Item findItemByItemNumber(@Param("itemNumber") String itemNumber);
}
