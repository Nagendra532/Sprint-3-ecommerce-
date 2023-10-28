package com.example.SpringbootJDBC.service;

import java.util.List;

import com.example.SpringbootJDBC.repository.entity.Item;

public interface ItemService
{

    Item save( Item item );

    void delete( int itemId );

    List<Item> all();

    Item findById( int itemId );

}