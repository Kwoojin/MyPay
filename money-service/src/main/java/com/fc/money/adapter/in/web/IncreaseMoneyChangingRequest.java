package com.fc.money.adapter.in.web;

import com.fc.money.application.port.in.IncreaseMoneyRequestCommand;
import lombok.Value;

@Value
public class IncreaseMoneyChangingRequest {

    String targetMembershipId;

    // 무조건 증액 요청 (충전)
    int amount;


    public IncreaseMoneyRequestCommand toCommand() {
        return IncreaseMoneyRequestCommand.builder()
                .targetMembershipId(targetMembershipId)
                .amount(amount)
                .build();
    }
}
