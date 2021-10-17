package com.example.PaymentService.service;

import com.example.PaymentService.Entity.transaction;

public interface transactionService {
    public transaction incurtransaction(transaction transaction);
    public transaction gettransactiondetailsbyId(int id);

}
