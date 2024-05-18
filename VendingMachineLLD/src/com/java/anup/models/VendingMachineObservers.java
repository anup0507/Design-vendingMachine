package com.java.anup.models;

import com.java.anup.notificationStrategies.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineObservers {
    private List<ISubscriber> subscriberList = new ArrayList<>();
    private void notifySubscribers(ProductShelf shelf) {
        for (ISubscriber subscriber : subscriberList) {
            subscriber.update(shelf);
        }
    }
}
