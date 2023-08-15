package com.fc.membership.application.service;

import com.fc.membership.application.port.in.FindMembershipCommand;
import com.fc.membership.application.port.in.FindMembershipUseCase;
import com.fc.membership.application.port.out.FindMembershipPort;
import com.fc.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@UseCase
public class FindMembership implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        return findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
    }

}
