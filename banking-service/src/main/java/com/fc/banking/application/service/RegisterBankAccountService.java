package com.fc.banking.application.service;

import com.fc.banking.adapter.out.persistence.external.bank.BankAccount;
import com.fc.banking.adapter.out.persistence.external.bank.GetBankAccountRequest;
import com.fc.banking.application.port.in.RegisterBankAccountCommand;
import com.fc.banking.application.port.in.RegisterBankAccountUseCase;
import com.fc.banking.application.port.out.RegisterBankAccountPort;
import com.fc.banking.application.port.out.RequestBankAccountInfoPort;
import com.fc.banking.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;
import org.fc.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;

    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        // 은행 계좌를 등록해야 하는 서비스 (비즈니스 로직)

        // (멤버 서비스도 확인?) 여기서는 skip

        // 1. 등록된 계좌인지 확인한다.
        // 외부의 은행에 이 계좌 정상인지 확인을 해야 한다.
        // Biz Logic -> External System
        // Port -> Adapter -> External System

        BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));

        // 2. 등록가능한 계좌라면, 등록한다. 성공하면, 등록에 성공한 등록 정보를 리턴
        // 2-1. 등록가능하지 않은 계좌라면, 에러를 리턴

        if (accountInfo.isValid()) {
            return registerBankAccountPort.createRegisteredBankAccount(
                    new RegisteredBankAccount.MembershipId(command.getMemberShipId())
                    , new RegisteredBankAccount.BankName(command.getBankName())
                    , new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber())
                    , new RegisteredBankAccount.LinkedStatusIsValid(command.isLinkedStatusIsValid())
            );
        } else {
            // ToDo : Error Handling

            return null;
        }
    }
}
