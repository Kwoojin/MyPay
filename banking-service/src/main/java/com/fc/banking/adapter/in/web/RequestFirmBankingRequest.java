package com.fc.banking.adapter.in.web;

import com.fc.banking.application.port.in.RequestFirmBankingCommand;
import lombok.Value;

@Value
public class RequestFirmBankingRequest {

    // a -> b 실물계좌로 요청을 하기 위한 Request

    String fromBankName;
    String fromBankAccountNumber;

    String toBankName;
    String toBankAccountNumber;

    int moneyAmount;    // only won


    public RequestFirmBankingCommand toCommand() {
        return RequestFirmBankingCommand.builder()
                .fromBankName(fromBankName)
                .fromBankAccountNumber(fromBankAccountNumber)
                .toBankName(toBankName)
                .toBankAccountNumber(toBankAccountNumber)
                .moneyAmount(moneyAmount)
                .build();
    }
}
