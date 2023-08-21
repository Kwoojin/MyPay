package com.fc.banking.application.port.out;

import com.fc.banking.adapter.out.persistence.external.bank.BankAccount;
import com.fc.banking.adapter.out.persistence.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {

    BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
