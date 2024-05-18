package com.demetgas.bankSystem.service;

import com.demetgas.bankSystem.model.Bank;
import com.demetgas.bankSystem.repository.BankRep;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bank")
@AllArgsConstructor
public class BankService {
    private BankRep bankRep;

    public List<Bank> getBanks(){
        return bankRep.findAll();
    }

    public Bank getBankById(String id){
        return bankRep.findById(id)
                .orElseThrow(()-> new RuntimeException("Bank not found!"));
    }

    public Bank createBank(Bank newBank){
        return bankRep.save(newBank);
    }


}
