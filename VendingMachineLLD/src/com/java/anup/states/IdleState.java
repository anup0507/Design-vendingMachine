package com.java.anup.states;

import com.java.anup.models.ProductShelf;
import com.java.anup.models.VendingMachine;

import java.lang.annotation.Native;

public class IdleState implements State {
    private VendingMachine vendingMachine;
    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void ChooseProduct() {
        vendingMachine.setCurrentState(vendingMachine.getProductSelectState());
        vendingMachine.getCurrentState().ChooseProduct();
    }
    @Override
    public void CollectMoney() {
        vendingMachine.setCurrentState(vendingMachine.getMoneyCollectedState());
        vendingMachine.getCurrentState().CollectMoney();
    }

    @Override
    public void DispenseProduct() {
        System.out.println(("First select the product .No product to Dispense!!"));
    }

    @Override
    public void NotifyAdminUsers() {
        vendingMachine.setCurrentState(vendingMachine.getNotifyAdminState());
        vendingMachine.getCurrentState().NotifyAdminUsers();
    }
    @Override
    public void CancelTransaction() {
        vendingMachine.setCurrentState(vendingMachine.getCancelState());
        vendingMachine.getCurrentState().CancelTransaction();
    }
}
