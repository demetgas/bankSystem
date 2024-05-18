package com.demetgas.bankSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private double amount;
    private String originatingAccountId;
    private String resultingAccountId;
    private String transactionReason;
}
