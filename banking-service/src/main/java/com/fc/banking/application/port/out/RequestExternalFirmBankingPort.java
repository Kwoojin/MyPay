package com.fc.banking.application.port.out;

import com.fc.banking.adapter.out.persistence.external.bank.ExternalFirmBankingRequest;
import com.fc.banking.adapter.out.persistence.external.bank.FirmBankingResult;

public interface RequestExternalFirmBankingPort {

    FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest request);
}
