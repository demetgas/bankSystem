package com.demetgas.bankSystem.repository;

import com.demetgas.bankSystem.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRep extends MongoRepository<Account,String> {
}
