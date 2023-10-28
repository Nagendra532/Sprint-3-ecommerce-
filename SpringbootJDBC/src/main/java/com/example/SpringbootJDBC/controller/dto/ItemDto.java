package com.example.SpringbootJDBC.controller.dto;

public class ItemDto
{

    private String image;

    private String name;

    private Integer price;

    public ItemDto( String image, String name, Integer price )
    {
        this.image=image;
        this.name=name;
        this.price=price;
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
    

   
}