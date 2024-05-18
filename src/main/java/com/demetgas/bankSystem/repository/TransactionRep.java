package com.demetgas.bankSystem.repository;

import com.demetgas.bankSystem.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRep extends MongoRepository<Transaction,String> {
}
