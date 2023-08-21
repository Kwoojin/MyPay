package com.fc.banking.adapter.out.persistence;

import com.fc.banking.domain.RegisteredBankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface RegisteredBankAccountMapper {
    RegisteredBankAccountMapper INSTANCE = Mappers.getMapper(RegisteredBankAccountMapper.class);

    default RegisteredBankAccount entityToDomain(RegisteredBankAccountJpaEntity entity) {
        return RegisteredBankAccount.generateRegisteredBankAccount(
                new RegisteredBankAccount.RegisteredBankAccountId(entity.getRegisteredBankAccountId()+""),
                new RegisteredBankAccount.MembershipId(entity.getMemberShipId()+""),
                new RegisteredBankAccount.BankName(entity.getBankName()),
                new RegisteredBankAccount.BankAccountNumber(entity.getBankAccountNumber()),
                new RegisteredBankAccount.LinkedStatusIsValid(entity.isLinkedStatusIsValid())
        );
    }


}
