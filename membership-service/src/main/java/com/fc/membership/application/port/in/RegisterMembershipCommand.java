package com.fc.membership.application.port.in;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import com.fc.common.SelfValidating;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = false)
@Builder
@Value
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    @NotNull
    String name;

    @NotNull
    String email;

    @NotNull
    @NotBlank
    String address;

    @AssertTrue
    boolean isValid;

    public RegisterMembershipCommand(String name, String email, String address, boolean isValid) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;

        this.validateSelf();
    }

}
