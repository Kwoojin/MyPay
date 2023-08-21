package com.fc.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredBankAccount {

    private final String registeredBankAccountId;

    private final String memberShipId;

    private final String bankName;

    private final String bankAccountNumber;

    private final boolean linkedStatusIsValid;

    public static RegisteredBankAccount generateRegisteredBankAccount(
            RegisteredBankAccountId registeredBankAccountId,
            MembershipId membershipId,
            BankName bankName,
            BankAccountNumber bankAccountNumber,
            LinkedStatusIsValid linkedStatusIsValid
    ) {
        return new RegisteredBankAccount(
                registeredBankAccountId.registeredBankAccountId,
                membershipId.membershipId,
                bankName.bankName,
                bankAccountNumber.bankAccountNumber,
                linkedStatusIsValid.linkedStatusIsValid
        );
    }

    @Value
    public static class RegisteredBankAccountId {
        String registeredBankAccountId ;
    }

    @Value
    public static class MembershipId {
        String membershipId;
    }

    @Value
    public static class BankName {
        String bankName ;
    }

    @Value
    public static class BankAccountNumber {
        String bankAccountNumber ;
    }

    @Value
    public static class LinkedStatusIsValid {
        boolean linkedStatusIsValid ;
    }



}
