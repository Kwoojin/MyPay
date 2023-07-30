package com.fc.membership.adapter.out.persistence;

import com.fc.membership.application.port.out.RegisterMembershipPort;
import com.fc.membership.domain.Membership;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort {

    private final SpringDateMembershipRepository membershipRepository;

    @Override
    public void createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipAggregateIdentifier membershipAggregateIdentifier
    ) {
        membershipRepository.save(
                MembershipJpaEntity.of(
                        membershipName.getNameValue(),
                        membershipEmail.getEmailValue(),
                        membershipAddress.getAddressValue(),
                        membershipIsValid.isValidValue(),
                        membershipAggregateIdentifier.getAggregateIdentifier()
                )
        );

    }
}
