package com.fc.membership.application.port.out;

import com.fc.membership.domain.Membership;

public interface FindMembershipPort {

    Membership findMembership(
            Membership.MembershipId membershipId
    );

}
