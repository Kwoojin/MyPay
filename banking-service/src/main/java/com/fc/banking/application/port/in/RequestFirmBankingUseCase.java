package com.fc.banking.application.port.in;

import com.fc.banking.domain.FirmBankingRequest;

public interface RequestFirmBankingUseCase {

    FirmBankingRequest registerFirmBankingRequest(RequestFirmBankingCommand command);

}
