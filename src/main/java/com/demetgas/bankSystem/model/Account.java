package com.demetgas.bankSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private String accountID;
    private String username;
    private double accountBalance;
    private String bankId;

    public Account(String accountID, String bankId){
        this.accountID = accountID;
        this.bankId = bankId;
    }
}
