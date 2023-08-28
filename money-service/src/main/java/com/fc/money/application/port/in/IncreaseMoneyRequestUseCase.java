package com.fc.money.application.port.in;

import com.fc.money.domain.MoneyChangingRequest;

public interface IncreaseMoneyRequestUseCase {

    MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command);

    MoneyChangingRequest increaseMoneyRequestAsync(IncreaseMoneyRequestCommand command);

}
