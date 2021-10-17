package com.example.PaymentService.dao;

import com.example.PaymentService.Entity.transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDao extends JpaRepository<transaction,Integer> {
}
