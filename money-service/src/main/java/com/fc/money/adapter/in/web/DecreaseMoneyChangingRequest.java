package com.fc.money.adapter.in.web;

import lombok.Value;

@Value
public class DecreaseMoneyChangingRequest {

    String targetMembershipId;

    int amount;

}
