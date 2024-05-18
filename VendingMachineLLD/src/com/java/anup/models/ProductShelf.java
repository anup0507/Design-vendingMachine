package com.java.anup.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductShelf {
    private Product product;
    int quantity;
    private String ShelfCode;
    public ProductShelf(String shelfCode, Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        ShelfCode = shelfCode;
    }

}
