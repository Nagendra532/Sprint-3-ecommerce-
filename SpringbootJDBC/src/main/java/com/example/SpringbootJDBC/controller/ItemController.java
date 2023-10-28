package com.example.SpringbootJDBC.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringbootJDBC.controller.dto.ItemDto;
import com.example.SpringbootJDBC.repository.entity.Item;
import com.example.SpringbootJDBC.service.ItemService;

@RestController
@RequestMapping( "/products" )
@CrossOrigin(origins = "http://localhost:8083")
public class ItemController
{

    final ItemService itemService;


    public ItemController( @Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }

    @GetMapping( "/all" )
    public Iterable<Item> getItems()
    {
        return itemService.all();
    }

    @CrossOrigin
    @PostMapping("/save")
    public Item save(@RequestBody ItemDto itemDto) {
   

        return itemService.save(new Item(itemDto));
    }



    @GetMapping( "/{id}" )
    public Item findItemById( @PathVariable Integer id )
    {
        return itemService.findById( id );
    }

    @PutMapping( value= "/save/{id}" )
    public Item update( @RequestBody ItemDto itemDto, @PathVariable Integer id )
    {
        Item item = itemService.findById( id );
        item.setImage( itemDto.getImage() );
        item.setName( itemDto.getName() );
        item.setPrice( itemDto.getPrice() );
        return itemService.save( item );
    }

    @DeleteMapping(value= "/delete/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }

}