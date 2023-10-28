package com.example.SpringbootJDBC.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.SpringbootJDBC.repository.entity.Item;

public interface ItemRepository
extends CrudRepository<Item, Integer>
{
}
