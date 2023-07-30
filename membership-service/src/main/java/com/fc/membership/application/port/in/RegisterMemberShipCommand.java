package com.fc.membership.application.port.in;

import common.SelfValidating;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = false)
@Builder
@Value
public class RegisterMemberShipCommand extends SelfValidating<RegisterMemberShipCommand> {

    @NotNull
    String name;

    @NotNull
    String email;

    @NotNull
    @NotBlank
    String address;

    @AssertTrue
    boolean isValid;

    boolean isCorp;

    public RegisterMemberShipCommand(String name, String email, String address, boolean isValid, boolean isCorp) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;

        this.validateSelf();
    }

}
