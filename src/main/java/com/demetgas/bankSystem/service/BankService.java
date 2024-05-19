package com.demetgas.bankSystem.service;

import com.demetgas.bankSystem.model.Bank;
import com.demetgas.bankSystem.repository.BankRep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        try {
            return bankRep.save(newBank);
        } catch (Exception e) {
            throw new RuntimeException("Error creating a new bank!", e);
        }
    }

    public double getTotalTransactionFeeAmount(String bankId) {
        Bank bank = getBankById(bankId);
        return bank.getTotalTransactionFeeAmount();
    }

    public double getTotalTransferAmount(String bankId) {
        Bank bank = getBankById(bankId);
        return bank.getTotalTransferAmount();
    }


}
