package com.fc.banking.adapter.out.persistence.external.bank;

import lombok.Value;

@Value
public class ExternalFirmBankingRequest {
    String fromBankName;

    String fromBankAccountNumber;

    String toBankName;

    String toBankAccountNumber;
}
