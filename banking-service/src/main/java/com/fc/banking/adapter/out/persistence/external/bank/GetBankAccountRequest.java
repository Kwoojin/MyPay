package com.fc.banking.adapter.out.persistence.external.bank;

import lombok.Value;

@Value
public class GetBankAccountRequest {

    String bankName;
    String bankAccountNumber;
}
