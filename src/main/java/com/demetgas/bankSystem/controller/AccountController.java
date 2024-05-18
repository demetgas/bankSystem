package com.demetgas.bankSystem.controller;

import com.demetgas.bankSystem.model.Account;
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
}
