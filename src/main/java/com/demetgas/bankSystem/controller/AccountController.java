package com.demetgas.bankSystem.controller;

import com.demetgas.bankSystem.model.Account;
import com.demetgas.bankSystem.repository.AccountRep;
import com.demetgas.bankSystem.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts(){
        return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account newAccount){
        return new ResponseEntity<>(accountService.createAccount(newAccount),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable String id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam String accountId, @RequestParam double amount) {
        return new ResponseEntity<>(accountService.withdraw(accountId, amount), HttpStatus.OK);
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam String accountId, @RequestParam double amount) {
        return new ResponseEntity<>(accountService.deposit(accountId, amount), HttpStatus.OK);
    }
}
