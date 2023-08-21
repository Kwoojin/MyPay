package com.fc.banking.application.port.in;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.fc.common.SelfValidating;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = false)
@Builder
@Value
public class RegisterBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {

    @NotNull
    String memberShipId;

    @NotNull
    String bankName;

    @NotNull
    String bankAccountNumber;

    boolean linkedStatusIsValid;

    public RegisterBankAccountCommand(String memberShipId, String bankName, String bankAccountNumber, boolean linkedStatusIsValid) {
        this.memberShipId = memberShipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;

        this.validateSelf();
    }

}
