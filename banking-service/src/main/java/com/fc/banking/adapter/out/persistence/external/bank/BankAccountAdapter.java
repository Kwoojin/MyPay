package com.fc.banking.adapter.out.persistence.external.bank;

import com.fc.banking.application.port.out.RequestBankAccountInfoPort;
import org.fc.common.ExternalSystemAdapter;

@ExternalSystemAdapter
public class BankAccountAdapter implements RequestBankAccountInfoPort{

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

        // 실제로 외부 은행에 http 을 통해서
        // 실제 은행 계좌 정보를 가져오고

        // 실제 은행 계좌 -> BankAccount
        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }

}
