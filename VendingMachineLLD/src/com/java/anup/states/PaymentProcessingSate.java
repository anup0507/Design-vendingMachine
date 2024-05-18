package com.java.anup.states;

import com.java.anup.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentProcessingSate implements State{
    private VendingMachine vendingMachine;

    private Scanner scanner;

    public PaymentProcessingSate(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        this.scanner = new Scanner(System.in);
    }
    private Payment getpaymentObject(int mode)
    {
        Payment payment=null;
        switch (mode)
        {
            case 1:
                payment=new CashPaymentMode();
                break;
            case 2:
                payment=new CardPaymentMode();
                break;
            default:
              //  System.out.println("Invalid mode selected");
                break;
        }
        return payment;
    }

    @Override
    public void ChooseProduct() {
        vendingMachine.setCurrentState(vendingMachine.getProductSelectState());
        vendingMachine.getCurrentState().ChooseProduct();
    }

    @Override
    public void CollectMoney() {

        vendingMachine.setCurrentState(vendingMachine.getMoneyCollectedState());
        while(true)
        {
            System.out.println("Please select the mode in which you want to pay?(1-Cash,2-Card)");
            String input=this.scanner.nextLine();
            int mode=1;
            try {
                mode = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + input);
            }
            Payment payment=getpaymentObject(mode);
            if(payment==null)
            {
                System.out.println("Invalid mode selected");
                continue;
            }
            payment.processPayment();
            vendingMachine.getPayments().add(payment);

            vendingMachine.setAmountReceived((int)(vendingMachine.getAmountReceived()+payment.getAmount()));
            System.out.println("Do you want to pay more?(Y/N)");

            String wanttoaddmore=this.scanner.nextLine();
            if(!wanttoaddmore.equalsIgnoreCase("Y"))
            {
                break;
            }
        }
    }
    @Override
    public void CancelTransaction() {
        System.out.println("Transaction is getting Cancelled now. Please wait. Do not press any button.");
        vendingMachine.setCurrentState(vendingMachine.getCancelState());
        vendingMachine.getCurrentState().CancelTransaction();
    }

    @Override
    public void NotifyAdminUsers() {
        System.out.println("Invalid Operation.We are at collecting money stage.Cannot notify admin now.");
    }

    @Override
    public void DispenseProduct() {
        vendingMachine.setCurrentState(vendingMachine.getDispenseProductState());
        vendingMachine.getCurrentState().DispenseProduct();
    }

}
