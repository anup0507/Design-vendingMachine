package com.java.anup.notificationStrategies;

import com.java.anup.models.ProductShelf;

public interface ISubscriber {
    void update(ProductShelf product);
}
