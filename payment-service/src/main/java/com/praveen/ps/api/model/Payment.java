package com.praveen.ps.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="payment")
public class Payment {
    @Id
    @GeneratedValue
    private int id;
    private  String paymentStatus;
    private  String transactionId;
    private int orderId;
    private double amount;
}
