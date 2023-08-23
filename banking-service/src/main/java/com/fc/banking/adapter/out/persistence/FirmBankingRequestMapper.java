package com.fc.banking.adapter.out.persistence;

import com.fc.banking.domain.FirmBankingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface FirmBankingRequestMapper {
    FirmBankingRequestMapper INSTANCE = Mappers.getMapper(FirmBankingRequestMapper.class);

    default FirmBankingRequest entityToDomain(FirmBankingRequestJpaEntity entity) {
        return FirmBankingRequest.generateFirmBankingRequest(
                new FirmBankingRequest.FirmBankingRequestId(entity.getRequestFirmBankingId() + ""),
                new FirmBankingRequest.FromBankName(entity.getFromBankName()),
                new FirmBankingRequest.FromBankAccountNumber(entity.getFromBankAccountNumber()),
                new FirmBankingRequest.ToBankName(entity.getToBankName()),
                new FirmBankingRequest.ToBankAccountNumber(entity.getToBankAccountNumber()),
                new FirmBankingRequest.MoneyAmount(entity.getMoneyAmount()),
                new FirmBankingRequest.FirmBankingStatus(entity.getFirmBankingStatus()),
                new FirmBankingRequest.Uuid(entity.getUuid())
        );
    }


}
