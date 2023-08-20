package com.fc.membership.application.service;

import com.fc.membership.application.port.in.RegisterMembershipCommand;
import com.fc.membership.application.port.in.RegisterMembershipUseCase;
import com.fc.membership.application.port.out.RegisterMembershipPort;
import com.fc.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.fc.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class RegisterMemberShipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;

    @Override
    public void registerMembership(RegisterMembershipCommand command) {
        registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipAggregateIdentifier("default")
        );
    }

}
