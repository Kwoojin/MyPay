package com.fc.membership.application.port.in;

import common.SelfValidating;
import lombok.*;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = false)
@Builder
@Value
public class ModifyMembershipCommand extends SelfValidating<ModifyMembershipCommand> {

    @NotNull
    String membershipId;

    @NotNull
    String name;

    @NotNull
    String email;

    @NotNull
    @NotBlank
    String address;

    @AssertTrue
    boolean isValid;

    public ModifyMembershipCommand(String membershipId, String name, String email, String address, boolean isValid) {
        this.membershipId = membershipId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;

        this.validateSelf();
    }

}
