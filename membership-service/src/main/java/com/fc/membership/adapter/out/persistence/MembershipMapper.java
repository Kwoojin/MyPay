package com.fc.membership.adapter.out.persistence;

import com.fc.membership.domain.Membership;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface MembershipMapper {
    MembershipMapper INSTANCE = Mappers.getMapper(MembershipMapper.class);

    default Membership entityToDomain(MembershipJpaEntity membership) {
        System.out.println(membership.toString());
        return Membership.generateMember(
                new Membership.MembershipId(membership.getMembershipId()+""),
                new Membership.MembershipName(membership.getName()),
                new Membership.MembershipEmail(membership.getEmail()),
                new Membership.MembershipAddress(membership.getAddress()),
                new Membership.MembershipIsValid(membership.isValid()),
                new Membership.MembershipAggregateIdentifier(membership.getAggregateIdentifier())
        );
    }


}
