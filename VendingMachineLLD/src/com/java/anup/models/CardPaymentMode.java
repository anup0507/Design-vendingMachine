package com.java.anup.models;

import java.time.LocalDateTime;
import java.util.Scanner;

public class CardPaymentMode extends Payment {
    private final Scanner scanner;
    public CardPaymentMode()
    {
        this.paymentMode=PaymentMode.CARD;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void processPayment() {
        System.out.println("Enter the amount you want to pay using card?");
        int amount=scanner.nextInt();
        this.setAmount(amount);

        this.setRefNo((int) (Math.random()*1000));

        this.setPaymentDate(LocalDateTime.now());
        System.out.println("Payment processing using card payment mode...");
        System.out.println("Payment Successful");
    }
    @Override
    public void refundPayment() {
        System.out.println("Refund of amount: "+this.getAmount()+" is initiated using Card Payment Mode.");
        System.out.println("Refund of amount: "+this.getAmount()+" is Done!!.");
    }
}
