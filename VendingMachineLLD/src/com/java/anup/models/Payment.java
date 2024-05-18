package com.java.anup.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class Payment {
    public double amount;
    public PaymentMode paymentMode;
    public LocalDateTime paymentDate;
    public int refNo;


    public abstract void processPayment();
    public abstract void refundPayment();

}
