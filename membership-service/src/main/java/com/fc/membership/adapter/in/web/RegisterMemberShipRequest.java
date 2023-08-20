package com.fc.membership.adapter.in.web;

import com.fc.membership.application.port.in.RegisterMembershipCommand;
import lombok.Value;

@Value
public class RegisterMemberShipRequest {

    String name;
    String address;
    String email;


    public RegisterMembershipCommand toCommand() {
        return RegisterMembershipCommand.builder()
                .name(name)
                .address(address)
                .email(email)
                .isValid(true)
                .build();
    }
}
