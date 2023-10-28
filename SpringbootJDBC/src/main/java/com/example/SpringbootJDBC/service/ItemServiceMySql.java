package com.example.SpringbootJDBC.service;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringbootJDBC.repository.ItemRepository;
import com.example.SpringbootJDBC.repository.entity.Item;

@Service
public class ItemServiceMySql
    implements ItemService
{
    private final ItemRepository itemRepository;

    public ItemServiceMySql( @Autowired ItemRepository itemRepository )
    {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save( Item item )
    {
        return itemRepository.save( item );
    }

    @Override
    public void delete( int itemId )
    {
        itemRepository.deleteById( itemId );
    }

    @Override
    public List<Item> all()
    {
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach( result::add );
        return result;
    }

    @Override
    public Item findById( int itemId )
    {
        return itemRepository.findById( itemId ).get();
    }
}