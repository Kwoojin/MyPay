package com.fc.banking.application.port.out;

import lombok.Value;

@Value
public class Membership {   // for banking-service

    String memberShipId;

    String name;

    String email;

    String address;

    Boolean isValid;

    String aggregateIdentifier;
}
