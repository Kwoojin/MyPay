package com.fc.money.application.port.in;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import com.fc.common.SelfValidating;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = false)
@Builder
@Value
public class IncreaseMoneyRequestCommand extends SelfValidating<IncreaseMoneyRequestCommand> {

    @NotNull
    String targetMembershipId;

    @NotNull
    int amount;

    public IncreaseMoneyRequestCommand(String targetMembershipId, int amount) {
        this.targetMembershipId = targetMembershipId;
        this.amount = amount;

        this.validateSelf();
    }

}
