package com.fc.membership.application.port.out;

import com.fc.membership.domain.Membership;

public interface RegisterMembershipPort {

    void createMembership(
            Membership.MembershipName membershipName
            , Membership.MembershipEmail membershipEmail
            , Membership.MembershipAddress membershipAddress
            , Membership.MembershipIsValid membershipIsValid
            , Membership.MembershipAggregateIdentifier membershipAggregateIdentifier
    );
}
