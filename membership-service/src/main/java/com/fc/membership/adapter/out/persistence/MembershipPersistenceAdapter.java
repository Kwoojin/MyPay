package com.fc.membership.adapter.out.persistence;

import com.fc.membership.application.port.out.FindMembershipPort;
import com.fc.membership.application.port.out.ModifyMembershipPort;
import com.fc.membership.application.port.out.RegisterMembershipPort;
import com.fc.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import com.fc.common.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public void createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp
    ) {
        membershipRepository.save(
                MembershipJpaEntity.of(
                        membershipName.getNameValue(),
                        membershipEmail.getEmailValue(),
                        membershipAddress.getAddressValue(),
                        membershipIsValid.isValidValue(),
                        membershipIsCorp.isCorpValue()
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
    public Membership modifyMembership(
            Membership.MembershipId membershipId,
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp
    ) {
        MembershipJpaEntity membershipJpaEntity = membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
        membershipJpaEntity.updateMembership(
                membershipName.getNameValue(),
                membershipAddress.getAddressValue(),
                membershipEmail.getEmailValue(),
                membershipIsValid.isValidValue(),
                membershipIsCorp.isCorpValue()
        );

        // return
        return MembershipMapper.INSTANCE.entityToDomain(membershipJpaEntity);

    }
}
