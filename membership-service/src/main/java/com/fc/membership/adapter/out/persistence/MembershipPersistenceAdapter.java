package com.fc.membership.adapter.out.persistence;

import com.fc.membership.application.port.out.FindMembershipPort;
import com.fc.membership.application.port.out.ModifyMembershipPort;
import com.fc.membership.application.port.out.RegisterMembershipPort;
import com.fc.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.fc.common.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

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

    @Override
    public Membership findMembership(Membership.MembershipId membershipId) {
        return MembershipMapper.INSTANCE.entityToDomain(
                membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()))
        );
    }

    @Override
    public Membership modifyMembership(Membership.MembershipId membershipId, Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid) {
        MembershipJpaEntity membershipJpaEntity = membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
        membershipJpaEntity.updateMembership(
                membershipName.getNameValue(),
                membershipAddress.getAddressValue(),
                membershipEmail.getEmailValue(),
                membershipIsValid.isValidValue()
        );

        // return
        return MembershipMapper.INSTANCE.entityToDomain(membershipJpaEntity);

    }
}
