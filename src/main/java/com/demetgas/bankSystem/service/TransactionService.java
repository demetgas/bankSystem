package com.demetgas.bankSystem.service;

import com.demetgas.bankSystem.model.Transaction;
import com.demetgas.bankSystem.repository.TransactionRep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private TransactionRep transactionRep;

    public List<Transaction> getTransactions(){
        return transactionRep.findAll();
    }
}
