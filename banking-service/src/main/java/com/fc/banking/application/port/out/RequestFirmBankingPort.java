package com.fc.banking.application.port.out;

import com.fc.banking.domain.FirmBankingRequest;

public interface RequestFirmBankingPort {

    FirmBankingRequest createFirmBankingRequest(
            FirmBankingRequest.FromBankName fromBankName,
            FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber,
            FirmBankingRequest.ToBankName toBankName,
            FirmBankingRequest.ToBankAccountNumber toBankAccountNumber,
            FirmBankingRequest.MoneyAmount moneyAmount,
            FirmBankingRequest.FirmBankingStatus firmBankingStatus
    );

    FirmBankingRequest modifyFirmBankingRequest(
            FirmBankingRequest.FirmBankingRequestId firmBankingRequestId,
            FirmBankingRequest.FirmBankingStatus firmBankingStatus,
            FirmBankingRequest.Uuid uuid
    );

}
