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

    public Account getAccountById(String id){
        return accountRep.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found!"));

    }
    public Account createAccount(Account newAccount){
        try {
            return accountRep.save(newAccount);
        } catch (Exception e) {
            // Log error and handle exception
            throw new RuntimeException("Error creating a new account!", e);
        }
    }
    public String withdraw(String accountId, double amount) {
        Account account = getAccountById(accountId);
        if (account.getAccountBalance() < amount) {
            return "Withdrawal Failed!";
        }
        account.setAccountBalance(account.getAccountBalance() - amount);
        accountRep.save(account);
        return "Withdrawal successful";
    }


    public String deposit(String accountId, double amount) {
        Account account = accountRep.findById(accountId).orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.setAccountBalance(account.getAccountBalance() + amount);
        accountRep.save(account);
        return "Deposit successful";
    }



}
