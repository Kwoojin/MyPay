package com.fc.banking.adapter.in.web;


import com.fc.banking.application.port.in.RequestFirmBankingCommand;
import com.fc.banking.application.port.in.RequestFirmBankingUseCase;
import com.fc.banking.domain.FirmBankingRequest;
import lombok.RequiredArgsConstructor;
import com.fc.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@WebAdapter
@RestController
public class RequestFirmBankingController {

    private final RequestFirmBankingUseCase requestFirmBankingUseCase;

    @PostMapping(path = "/banking/firm-banking/request")
    public FirmBankingRequest registerBankAccount(@RequestBody RequestFirmBankingRequest request) {
        RequestFirmBankingCommand command = request.toCommand();

        return requestFirmBankingUseCase.registerFirmBankingRequest(command);
    }
}
