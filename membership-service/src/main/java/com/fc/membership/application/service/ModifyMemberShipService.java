package com.fc.membership.application.service;

import com.fc.membership.application.port.in.ModifyMembershipCommand;
import com.fc.membership.application.port.in.ModifyMembershipUseCase;
import com.fc.membership.application.port.in.RegisterMembershipCommand;
import com.fc.membership.application.port.in.RegisterMembershipUseCase;
import com.fc.membership.application.port.out.ModifyMembershipPort;
import com.fc.membership.application.port.out.RegisterMembershipPort;
import com.fc.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@UseCase
public class ModifyMemberShipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        return modifyMembershipPort.modifyMembership(
                new Membership.MembershipId(command.getMembershipId()),
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid())
        );
    }
}
