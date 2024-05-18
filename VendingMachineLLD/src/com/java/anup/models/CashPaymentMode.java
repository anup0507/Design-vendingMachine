package com.java.anup.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CashPaymentMode extends Payment {
    private Scanner scanner;

    public CashPaymentMode()
    {
        this.paymentMode=PaymentMode.CASH;
        this.scanner=new Scanner(System.in);
    }

    @Override
    public void processPayment() {
        System.out.println("Add Coins in the tray to make the payment.");
        int amount=scanner.nextInt();
        this.setAmount(amount);

        this.setRefNo((int) (Math.random()*1000));

        this.setPaymentDate(LocalDateTime.now());
        System.out.println("Payment processing using cash payment mode...");
        System.out.println("Payment Successful");
    }
    @Override
    public void refundPayment() {
        System.out.println("Refund of amount: "+this.getAmount()+" is initiated .Please collect coins from tray below.");
        System.out.println("Refund of amount: "+this.getAmount()+" is Done!!.");
    }
}
