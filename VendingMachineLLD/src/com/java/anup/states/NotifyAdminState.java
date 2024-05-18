package com.java.anup.states;

import com.java.anup.models.ProductShelf;
import com.java.anup.models.VendingMachine;

public class NotifyAdminState implements State{
    private VendingMachine vendingMachine;
    public NotifyAdminState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void ChooseProduct() {
        System.out.println("Please let us notify admin users first. Please wait. Do not press any button.");

    }

    @Override
    public void CollectMoney() {
        System.out.println("Please let us notify admin users first. Please wait. Do not press any button.");
    }

    @Override
    public void DispenseProduct() {
        System.out.println("Please let us notify admin users first. Please wait. Do not press any button.");
    }

    @Override
    public void CancelTransaction() {
        System.out.println("Please let us notify admin users first. Please wait. Do not press any button.");
    }

    @Override
    public void NotifyAdminUsers() {
        for(ProductShelf productShelf: vendingMachine.getInventory())
        {
            if(productShelf.getQuantity()<vendingMachine.getThresholdQuantity())
            {
                System.out.println("Notifying Admin users about the Product Code: "+productShelf.getShelfCode()+" Product Name: "+productShelf.getProduct().getName()+", Quantity: "+productShelf.getProduct().getPrice() +
                        " has going out of stock. please refill soon!!");
            }
        }
        vendingMachine.setCurrentState(vendingMachine.getIdleState());
    }
}
