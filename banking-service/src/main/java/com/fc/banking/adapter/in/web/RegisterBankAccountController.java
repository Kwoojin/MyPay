package com.fc.banking.adapter.in.web;


import com.fc.banking.application.port.in.RegisterBankAccountCommand;
import com.fc.banking.application.port.in.RegisterBankAccountUseCase;
import com.fc.banking.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;
import org.fc.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@WebAdapter
@RestController
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping(path = "/banking/account/register")
    public RegisteredBankAccount registerBankAccount(@RequestBody RegisterBankAccountRequest request) {
        RegisterBankAccountCommand command = request.toCommand();

        return registerBankAccountUseCase.registerBankAccount(command);
    }
}
