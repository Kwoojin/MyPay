package com.fc.banking.adapter.out.external.bank;

import lombok.Value;

@Value
public class GetBankAccountRequest {

    String bankName;
    String bankAccountNumber;
}
