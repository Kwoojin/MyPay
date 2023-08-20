package com.fc.membership.adapter.in.web;

import com.fc.membership.application.port.in.ModifyMembershipCommand;
import lombok.Value;

@Value
public class ModifyMemberShipRequest {

    String name;
    String address;
    String email;
    boolean isValid;


    public ModifyMembershipCommand toCommand(String membershipId) {
        return ModifyMembershipCommand.builder()
                .membershipId(membershipId)
                .name(name)
                .address(address)
                .email(email)
                .isValid(isValid)
                .build();
    }
}
