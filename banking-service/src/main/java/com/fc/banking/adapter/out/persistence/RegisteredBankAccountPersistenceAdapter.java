package com.fc.banking.adapter.out.persistence;

import com.fc.banking.application.port.out.RegisterBankAccountPort;
import com.fc.banking.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;
import com.fc.common.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final SpringDataRegisteredBankAccountRepository registeredBankAccountRepository;

    @Override
    public RegisteredBankAccount createRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    ) {
        RegisteredBankAccountJpaEntity entity = registeredBankAccountRepository.save(
                RegisteredBankAccountJpaEntity.of(
                        Long.parseLong(membershipId.getMembershipId()),
                        bankName.getBankName(),
                        bankAccountNumber.getBankAccountNumber(),
                        linkedStatusIsValid.isLinkedStatusIsValid()
                )
        );

        return RegisteredBankAccountMapper.INSTANCE.entityToDomain(entity);
    }

}
