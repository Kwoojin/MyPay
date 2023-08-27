package com.fc.banking.application.port.in;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import com.fc.common.SelfValidating;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = false)
@Builder
@Value
public class RequestFirmBankingCommand extends SelfValidating<RequestFirmBankingCommand> {

    @NotNull
    String fromBankName;

    @NotNull
    String fromBankAccountNumber;

    @NotNull
    String toBankName;

    @NotNull
    String toBankAccountNumber;

    int moneyAmount;

    public RequestFirmBankingCommand(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, int moneyAmount) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;

        this.validateSelf();
    }
}
