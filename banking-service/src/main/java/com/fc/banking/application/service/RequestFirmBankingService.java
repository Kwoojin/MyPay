package com.fc.banking.application.service;

import com.fc.banking.adapter.out.persistence.external.bank.ExternalFirmBankingRequest;
import com.fc.banking.adapter.out.persistence.external.bank.FirmBankingResult;
import com.fc.banking.application.port.in.RequestFirmBankingCommand;
import com.fc.banking.application.port.in.RequestFirmBankingUseCase;
import com.fc.banking.application.port.out.RequestExternalFirmBankingPort;
import com.fc.banking.application.port.out.RequestFirmBankingPort;
import com.fc.banking.domain.FirmBankingRequest;
import lombok.RequiredArgsConstructor;
import org.fc.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Transactional
@UseCase
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

    private final RequestFirmBankingPort requestFirmBankingPort;

    private final RequestExternalFirmBankingPort requestExternalFirmBankingPort;

    @Override
    public FirmBankingRequest registerFirmBankingRequest(RequestFirmBankingCommand command) {

        // Business Logic
        // a -> b 계좌

        // 1. 요청에 대해 정보를 먼저 write . "요청" 상태로
        FirmBankingRequest firmBankingRequest = requestFirmBankingPort.createFirmBankingRequest(
                new FirmBankingRequest.FromBankName(command.getFromBankName()),
                new FirmBankingRequest.FromBankAccountNumber(command.getFromBankAccountNumber()),
                new FirmBankingRequest.ToBankName(command.getToBankName()),
                new FirmBankingRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
                new FirmBankingRequest.MoneyAmount(command.getMoneyAmount()),
                new FirmBankingRequest.FirmBankingStatus(0)
        );

        // 2. 외부 은행에 펌뱅킹 요청
        FirmBankingResult result = requestExternalFirmBankingPort.requestExternalFirmBanking(new ExternalFirmBankingRequest(
                command.getFromBankName(),
                command.getFromBankAccountNumber(),
                command.getToBankName(),
                command.getToBankAccountNumber()
        ));

        // Transactional UUID
        UUID randomUUID = UUID.randomUUID();

        // 3. 결과에 따라서 1번에서 작성했던 FirmBankingRequest 정보를 Update 
        // - 1:성공, 2:실패
        int firmBankingStatus = result.getResultCode() == 0 ? 1 : 2;

        // 4. 결과를 리턴
        return requestFirmBankingPort.modifyFirmBankingRequest(
                new FirmBankingRequest.FirmBankingRequestId(firmBankingRequest.getFirmBankingRequestId()),
                new FirmBankingRequest.FirmBankingStatus(firmBankingStatus),
                new FirmBankingRequest.Uuid(randomUUID.toString())
        );
    }
}
