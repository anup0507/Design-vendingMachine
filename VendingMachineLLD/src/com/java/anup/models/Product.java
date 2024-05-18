package com.java.anup.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product {
    String name;
    int price;
    String description;

    public Product(String name, int price, String Description) {
        this.name = name;
        this.price = price;
        this.description = Description;
    }

}
