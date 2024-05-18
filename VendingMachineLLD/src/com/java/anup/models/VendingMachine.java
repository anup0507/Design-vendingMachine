package com.java.anup.models;

import com.java.anup.states.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class VendingMachine {
    List<ProductShelf> inventory;
    int amountReceived = 0;
    Map<String, Integer> productsSelected;
    State idleState;
    State notifyAdminState;
    State productSelectState;
    State moneyCollectedState;
    State currentState;
    State cancelState;
    State dispenseProductState;
    int thresholdQuantity;
    int totalAmounttobePaid;
    private List<Payment> payments;
    VendingMachineStatus vendingMachineStatus;

    public VendingMachine(List<ProductShelf> inventory,int thresholdQuantity) {
        this.inventory = inventory;
        idleState = new IdleState(this);
        notifyAdminState = new NotifyAdminState(this);

        moneyCollectedState = new PaymentProcessingSate(this);
        currentState = idleState;
        cancelState = new CancelState(this);
        dispenseProductState = new DispenseProductState(this);
        productSelectState = new ProductSelectState(this);
        this.amountReceived=0;
        this.thresholdQuantity = thresholdQuantity;
        this.totalAmounttobePaid=0;
        this.vendingMachineStatus=VendingMachineStatus.AVAILABLE;
        this.productsSelected= new HashMap<>();
        this.payments = new ArrayList<>();
    }
    public void UpdateInventory(ProductShelf productShelf) {
        for (ProductShelf shelf : inventory) {
            if(shelf.getShelfCode().equals(productShelf.getShelfCode()))
            {
                shelf.setQuantity(shelf.getQuantity()+productShelf.getQuantity());
            }
        }

    }
    public void deleteShelf(String shelfCode) {
        for (ProductShelf shelf : inventory) {
            if(shelf.getShelfCode().equals(shelfCode))
            {
                inventory.remove(shelf);
            }
        }
    }
    public void addShelf(ProductShelf productShelf) {
        inventory.add(productShelf);
    }

    public void ChooseProduct() {
        currentState.ChooseProduct();
    }

    public void CollectMoney() {
        currentState.CollectMoney();
    }

    public void DispenseProduct() {
        currentState.DispenseProduct();
    }

    public void CancelTransaction() {
        currentState.CancelTransaction();
    }
    public void NotifyAdminUsers() {
        if(!(currentState instanceof IdleState)){
            System.out.println("Admin cannot be notified in the current state of the vending machine");
            return;
        }
        currentState.NotifyAdminUsers();
    }
    public void setState(State state) {
        currentState = state;
    }
    public void DisplayInventory()
    {
        for (ProductShelf shelf : inventory) {
            if(shelf.getQuantity()>0)
                System.out.println("Shelf Code: " + shelf.getShelfCode() + " Product: " + shelf.getProduct().getName() +
                        " Price: " + shelf.getProduct().getPrice() + ", Quantity: "+shelf.getQuantity());
        }
    }
    public void exit() {
        setState(cancelState);
        currentState.CancelTransaction();
        System.out.println("Exiting the vending machine");
    }

}
