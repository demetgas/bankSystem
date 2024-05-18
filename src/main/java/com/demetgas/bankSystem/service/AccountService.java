package com.demetgas.bankSystem.service;

import com.demetgas.bankSystem.model.Account;
import com.demetgas.bankSystem.repository.AccountRep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRep accountRep;
    public List<Account> getAccounts(){
        return accountRep.findAll();
    }

    public Account createAccount(Account newAccount){
        try {
            return accountRep.save(newAccount);
        } catch (Exception e) {
            // Log error and handle exception
            throw new RuntimeException("Error creating a new account!", e);
        }
    }

}
