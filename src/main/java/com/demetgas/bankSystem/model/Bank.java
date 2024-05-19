package com.demetgas.bankSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
    @Id
    private String bankId;
    private String bankName;
    private List<Account> accountList = new ArrayList<>();
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;

    public Bank(String bankId, String bankName){
        this.bankId = bankId;
        this.bankName=bankName;
    }

    public void addAccount(Account account){
        try {
            if (bankId.equals(account.getBankId())){
                accountList.add(account);
            }
        }catch (Exception e){
            throw new RuntimeException("Error", e);

        }

    }
}
