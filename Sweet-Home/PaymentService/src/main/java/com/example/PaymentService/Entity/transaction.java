package com.example.PaymentService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;
    private String paymentMode;
    @Column(name = "bookingId", nullable = false)
    private int bookingId;
    @Column(name = "upiId")
    private String upiId;
    private String cardNumber;
}
