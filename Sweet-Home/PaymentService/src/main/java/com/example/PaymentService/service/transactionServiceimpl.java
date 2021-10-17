package com.example.PaymentService.service;

import com.example.PaymentService.Entity.transaction;
import com.example.PaymentService.dao.TransactionDao;
import com.example.PaymentService.dto.TransactionDto;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class transactionServiceimpl implements transactionService {

    @Autowired
    private TransactionDao transactionDao;

    private TransactionDto transactionDto;


    @Override
    public transaction incurtransaction(transaction Transaction) {
       return transactionDao.save(Transaction);
    }

    @Override
    public transaction gettransactiondetailsbyId(int id) {
        return transactionDao.getById(id);
    }
}
