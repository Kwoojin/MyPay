package com.fc.money.adapter.out.service;

import lombok.Getter;

@Getter
public class Membership {

    private final String membershipId;
    private final String name;
    private final String email;
    private final String address;
    private final Boolean isValid;
    private final String isCorp;

    public Membership(String membershipId, String name, String email, String address, Boolean isValid, String isCorp) {
        this.membershipId = membershipId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;
    }
}
