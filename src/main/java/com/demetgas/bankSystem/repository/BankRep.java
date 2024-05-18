package com.demetgas.bankSystem.repository;

import com.demetgas.bankSystem.model.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankRep extends MongoRepository<Bank,String> {
}
