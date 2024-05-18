package com.java.anup.notificationStrategies;

import com.java.anup.models.Product;
import com.java.anup.models.ProductShelf;

public class TestSubscriber implements ISubscriber {
    @Override
    public void update(ProductShelf shelf) {
        System.out.println("Got request of Product: " + shelf.getProduct().getName() + " going out of stock. Refilling Soon!!");

    }
}
