package com.fc.banking.application.port.out;

import com.fc.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    RegisteredBankAccount createRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId
            , RegisteredBankAccount.BankName bankName
            , RegisteredBankAccount.BankAccountNumber bankAccountNumber
            , RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    );
}
