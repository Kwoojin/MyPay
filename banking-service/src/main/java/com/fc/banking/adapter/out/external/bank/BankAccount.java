package com.fc.banking.adapter.out.external.bank;

import lombok.Value;

@Value
public class BankAccount {

    String bankName;
    String bankAccountNumber;
    boolean isValid;

}
