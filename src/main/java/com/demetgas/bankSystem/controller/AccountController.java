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

    @GetMapping("/{id}/balance")
    public ResponseEntity<Double> getAccountBalance(@PathVariable String id) {
        return new ResponseEntity<>(accountService.getAccountBalance(id), HttpStatus.OK);
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable String id, @RequestParam double amount) {
        accountService.withdraw(id, amount);
        return new ResponseEntity<>("Withdrawal successful", HttpStatus.OK);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<String> deposit(@PathVariable String id, @RequestParam double amount) {
        accountService.deposit(id, amount);
        return new ResponseEntity<>("Deposit successful", HttpStatus.OK);
    }
}
