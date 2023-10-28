package com.example.SpringbootJDBC.repository.entity;



import com.example.SpringbootJDBC.controller.dto.ItemDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item
{
    @Id 
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String image;

    private String name;

    private Integer price;

    public Item()
    {
    }

    public Item( ItemDto itemDto )
    {
        this.image = itemDto.getImage();
        this.name = itemDto.getName();
        this.price = itemDto.getPrice();
    }

    

	

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
    public String toString()
    {
        return "Item{" + "name=" + name + ", url='" + image + '\'' + ", price='" + price + '\'' + ", id='"
            + id + '\'' + '}';
    }
}
