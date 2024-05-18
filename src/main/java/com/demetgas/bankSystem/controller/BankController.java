package com.demetgas.bankSystem.controller;

import com.demetgas.bankSystem.model.Bank;
import com.demetgas.bankSystem.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
@AllArgsConstructor
public class BankController {
    private final BankService bankService;

    @GetMapping
    public ResponseEntity<List<Bank>> getBanks(){
        return new ResponseEntity<>(bankService.getBanks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable String id){
        return new ResponseEntity<>(bankService.getBankById(id),HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<Bank> createBank(@RequestBody Bank newBank){
        return new ResponseEntity<>(bankService.createBank(newBank),HttpStatus.CREATED);
    }

}
