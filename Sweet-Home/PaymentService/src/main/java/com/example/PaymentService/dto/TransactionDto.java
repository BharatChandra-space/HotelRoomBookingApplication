package com.example.PaymentService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private int transactionId;
    private String paymentMode;
    private int bookingId;
    private String upiId;
    private String cardNumber;
}
