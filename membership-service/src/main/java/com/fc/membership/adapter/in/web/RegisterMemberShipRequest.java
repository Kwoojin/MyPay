package com.fc.membership.adapter.in.web;

import com.fc.membership.application.port.in.RegisterMemberShipCommand;
import lombok.Value;

@Value
public class RegisterMemberShipRequest {

    String name;
    String address;
    String email;
    boolean isCorp;


    public RegisterMemberShipCommand toCommand() {
        return RegisterMemberShipCommand.builder()
                .name(name)
                .address(address)
                .email(email)
                .isValid(true)
                .isCorp(isCorp)
                .build();
    }
}
