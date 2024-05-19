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

    public double getAccountBalance(String id) {
        Account account = accountRep.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found!"));
        return account.getAccountBalance();
    }
    public Account createAccount(Account newAccount){
        try {
            return accountRep.save(newAccount);
        } catch (Exception e) {
            throw new RuntimeException("Error creating a new account!", e);
        }
    }
    public double withdraw(String accountId, double amount) {
        Account account = getAccountById(accountId);
        if (account.getAccountBalance() < amount) {
            throw new RuntimeException("Withdrawal Failed!");
        }
        account.setAccountBalance(account.getAccountBalance() - amount);
        accountRep.save(account);
        return amount;
    }
    
    public double deposit(String accountId, double amount) {
        Account account = accountRep.findById(accountId).orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.setAccountBalance(account.getAccountBalance() + amount);
        accountRep.save(account);
        return amount;
    }



}
