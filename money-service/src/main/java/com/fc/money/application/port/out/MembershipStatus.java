package com.fc.money.application.port.out;

import lombok.Value;

@Value
public class MembershipStatus {

    String membershipId;
    boolean isValid;
}
