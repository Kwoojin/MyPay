package com.fc.membership.adapter.in.web;


import com.fc.membership.application.port.in.RegisterMembershipCommand;
import com.fc.membership.application.port.in.RegisterMembershipUseCase;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@WebAdapter
@RestController
public class RegisterMemberShipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping(path = "/membership/register")
    public void registerMemberShip(@RequestBody RegisterMemberShipRequest request) {
        // (1). request

        // (2). 추상화 계층 : request -> Command ( request 가 수정되더 라도 port 로서 interface 가 영향 받지 않기 위함 )
        RegisterMembershipCommand command = request.toCommand();

        // (3). UseCase ~~ ( command )
        registerMembershipUseCase.registerMembership(command);
    }
}
