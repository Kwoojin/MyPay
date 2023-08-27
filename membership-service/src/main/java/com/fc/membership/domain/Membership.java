package com.fc.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    private final String memberShipId;

    private final String name;

    private final String email;

    private final String address;

    private final boolean isValid;

    private final boolean isCorp;

    public static Membership generateMember(MembershipId membershipId, MembershipName membershipName, MembershipEmail membershipEmail, MembershipAddress membershipAddress, MembershipIsValid membershipIsValid, MembershipIsCorp  membershipIsCorp) {
        return new Membership(
                membershipId.membershipId,
                membershipName.nameValue,
                membershipEmail.emailValue,
                membershipAddress.addressValue,
                membershipIsValid.isValidValue,
                membershipIsCorp.isCorpValue
        );
    }

    @Value
    public static class MembershipId {
        String membershipId ;
    }

    @Value
    public static class MembershipName {
        String nameValue;
    }

    @Value
    public static class MembershipEmail {
        String emailValue;
    }

    @Value
    public static class MembershipAddress {
        String addressValue;
    }

    @Value
    public static class MembershipIsValid {
        boolean isValidValue;
    }

    @Value
    public static class MembershipIsCorp {
        boolean isCorpValue;
    }
}
