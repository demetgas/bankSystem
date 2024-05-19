package com.demetgas.bankSystem.controller;

import com.demetgas.bankSystem.model.Transaction;
import com.demetgas.bankSystem.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransactions(){
        return new ResponseEntity<>(transactionService.getTransactions(), HttpStatus.OK);
    }
}
