package com.java.anup.states;

import com.java.anup.models.VendingMachine;

public class DispenseProductState implements State {
    private VendingMachine vendingMachine;
    public DispenseProductState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void ChooseProduct() {
        System.out.println("We are Dispensing the product. Please wait. Do not press any button.");
    }

    @Override
    public void CollectMoney() {
        System.out.println("We are Dispensing the product. Please wait. Do not press any button.");
    }

    @Override
    public void DispenseProduct() {
        System.out.println("Checking if the product is available");
        if(vendingMachine.getProductsSelected().size()==0)
        {
            System.out.println("No product selected /Invalid product code. Please select a valid product code");
            vendingMachine.setCurrentState(vendingMachine.getCancelState());
            vendingMachine.getCurrentState().CancelTransaction();
            return;
        }
        else if(vendingMachine.getTotalAmounttobePaid()>vendingMachine.getAmountReceived())
        {
            System.out.println("Insufficient amount paid.Cancelling transaction");
            vendingMachine.setCurrentState(vendingMachine.getCancelState());
            vendingMachine.getCurrentState().CancelTransaction();
            return;
        }
        System.out.println("Dispensing all selected products. Please collect it from tray below.");
        if(vendingMachine.getAmountReceived()>vendingMachine.getTotalAmounttobePaid())
        {
            System.out.println("Returning the extra amount received: "+(vendingMachine.getAmountReceived()-vendingMachine.getTotalAmounttobePaid())+". Please collect your money.");
        }
        vendingMachine.getProductsSelected().clear();
        vendingMachine.setAmountReceived(0);
        vendingMachine.setTotalAmounttobePaid(0);
        vendingMachine.setCurrentState(vendingMachine.getNotifyAdminState());
        vendingMachine.getCurrentState().NotifyAdminUsers();
    }

    @Override
    public void CancelTransaction() {
        System.out.println("We are Dispensing the product. Please wait. Do not press any button.");
    }

    @Override
    public void NotifyAdminUsers() {
        System.out.println("We are Dispensing the product. Please wait. Do not press any button.");
    }

}
