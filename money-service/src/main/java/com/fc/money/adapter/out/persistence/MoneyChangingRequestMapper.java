package com.fc.money.adapter.out.persistence;

import com.fc.money.domain.MoneyChangingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MoneyChangingRequestMapper {
    MoneyChangingRequestMapper INSTANCE = Mappers.getMapper(MoneyChangingRequestMapper.class);

    default MoneyChangingRequest entityToDomain(MoneyChangingRequestJpaEntity moneyChangingRequestJpaEntity) {
        return MoneyChangingRequest.generateMoneyChangingRequest(
                new MoneyChangingRequest.MoneyChangingRequestId(moneyChangingRequestJpaEntity.getMoneyChangingRequestId()+""),
                new MoneyChangingRequest.TargetMembershipId(moneyChangingRequestJpaEntity.getTargetMembershipId()),
                new MoneyChangingRequest.MoneyChangingType(moneyChangingRequestJpaEntity.getMoneyChangingType()),
                new MoneyChangingRequest.ChangingMoneyAmount(moneyChangingRequestJpaEntity.getMoneyAmount()),
                new MoneyChangingRequest.MoneyChangingStatus(moneyChangingRequestJpaEntity.getChangingMoneyStatus()),
                moneyChangingRequestJpaEntity.getUuid()
        );
    }


}
