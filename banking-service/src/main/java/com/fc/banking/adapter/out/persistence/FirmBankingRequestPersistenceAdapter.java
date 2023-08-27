package com.fc.banking.adapter.out.persistence;

import com.fc.banking.application.port.out.RequestFirmBankingPort;
import com.fc.banking.domain.FirmBankingRequest;
import lombok.RequiredArgsConstructor;
import com.fc.common.PersistenceAdapter;

import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class FirmBankingRequestPersistenceAdapter implements RequestFirmBankingPort {

    private final SpringDataFirmBankingRequestRepository firmBankingRequestRepository;

    @Override
    public FirmBankingRequest createFirmBankingRequest(
            FirmBankingRequest.FromBankName fromBankName,
            FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber,
            FirmBankingRequest.ToBankName toBankName,
            FirmBankingRequest.ToBankAccountNumber toBankAccountNumber,
            FirmBankingRequest.MoneyAmount moneyAmount,
            FirmBankingRequest.FirmBankingStatus firmBankingStatus
    ) {
        FirmBankingRequestJpaEntity entity = firmBankingRequestRepository.save(FirmBankingRequestJpaEntity.of(
                        fromBankName.getFromBankName(),
                        fromBankAccountNumber.getFromBankAccountNumber(),
                        toBankName.getToBankName(),
                        toBankAccountNumber.getToBankAccountNumber(),
                        moneyAmount.getMoneyAmount(),
                        firmBankingStatus.getFirmBankingStatus(),
                        UUID.randomUUID().toString()
                )
        );

        return FirmBankingRequestMapper.INSTANCE.entityToDomain(entity);
    }

    @Override
    public FirmBankingRequest modifyFirmBankingRequest(
            FirmBankingRequest.FirmBankingRequestId firmBankingRequestId,
            FirmBankingRequest.FirmBankingStatus firmBankingStatus,
            FirmBankingRequest.Uuid uuid
    ) {
        FirmBankingRequestJpaEntity entity = firmBankingRequestRepository.getById(Long.parseLong(firmBankingRequestId.getFirmBankingRequestId()));
        entity.updateFirmBankingStatus(firmBankingStatus.getFirmBankingStatus(), uuid.getUuid());

        return FirmBankingRequestMapper.INSTANCE.entityToDomain(entity);
    }
}
