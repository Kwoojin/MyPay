package com.fc.banking.adapter.in.web;

import com.fc.banking.application.port.in.RegisterBankAccountCommand;
import lombok.Value;

@Value
public class RegisterBankAccountRequest {

    String memberShipId;
    String bankName;
    String bankAccountNumber;
    boolean linkedStatusIsValid;


    public RegisterBankAccountCommand toCommand() {
        return RegisterBankAccountCommand.builder()
                .memberShipId(memberShipId)
                .bankName(bankName)
                .bankAccountNumber(bankAccountNumber)
                .linkedStatusIsValid(linkedStatusIsValid)
                .build();
    }
}
