package com.java.anup.states;

import com.java.anup.models.Payment;
import com.java.anup.models.VendingMachine;

public class CancelState implements State{
    private VendingMachine vendingMachine;
    public CancelState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void ChooseProduct() {
        System.out.println("Transaction is getting cancelled. Please wait. Do not press any button.");
    }

    @Override
    public void CollectMoney() {
        System.out.println("Transaction is getting cancelled. Please wait. Do not press any button.");
    }

    @Override
    public void DispenseProduct() {
        System.out.println("Transaction is getting cancelled. Please wait. Do not press any button.");
    }

    @Override
    public void CancelTransaction() {
        System.out.println("Transaction is getting cancelled. Please wait. Do not press any button.");
        if(vendingMachine.getProductsSelected().size()!=0)
        {
            for(String shelfCode: vendingMachine.getProductsSelected().keySet())
            {
                int quantitySelected=vendingMachine.getProductsSelected().get(shelfCode);

                for(int j=0;j<vendingMachine.getInventory().size();j++)
                {
                    if(vendingMachine.getInventory().get(j).getShelfCode().equals(shelfCode))
                    {
                        vendingMachine.getInventory().get(j).setQuantity(vendingMachine.getInventory().get(j).getQuantity()+quantitySelected);
                    }
                }

            }
            vendingMachine.getProductsSelected().clear();
        }
        if(vendingMachine.getAmountReceived()>0)
        {
            System.out.println("Returning the amount received: "+vendingMachine.getAmountReceived()+". Please collect your money.");
            for(Payment payment:vendingMachine.getPayments())
            {
                payment.refundPayment();
            }
            vendingMachine.setAmountReceived(0);
        }
        if(vendingMachine.getTotalAmounttobePaid()>0)
        {
            vendingMachine.setTotalAmounttobePaid(0);

        }
        vendingMachine.setCurrentState(vendingMachine.getIdleState());
    }

    @Override
    public void NotifyAdminUsers() {
        System.out.println("Transaction is getting cancelled. Please wait. Do not press any button.");
    }
}
