package com.fc.banking.adapter.out.external.bank;

import lombok.Value;

@Value
public class ExternalFirmBankingRequest {
    String fromBankName;

    String fromBankAccountNumber;

    String toBankName;

    String toBankAccountNumber;
}
