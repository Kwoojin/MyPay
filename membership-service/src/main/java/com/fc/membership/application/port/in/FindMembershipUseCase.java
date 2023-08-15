package com.fc.membership.application.port.in;

import com.fc.membership.domain.Membership;

public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);

}
