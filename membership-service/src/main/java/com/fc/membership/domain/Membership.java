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

    private final Boolean isValid;

    private final String aggregateIdentifier;

    public static Membership generateMember(MembershipId membershipId, MembershipName membershipName, MembershipEmail membershipEmail, MembershipAddress membershipAddress, MembershipIsValid membershipIsValid, MembershipAggregateIdentifier membershipAggregateIdentifier) {
        return new Membership(
                membershipId.membershipId,
                membershipName.nameValue,
                membershipEmail.emailValue,
                membershipAddress.addressValue,
                membershipIsValid.isValidValue,
                membershipAggregateIdentifier.aggregateIdentifier
        );
    }

    @Value
    public static class MembershipId {
        public MembershipId(String value) {
            this.membershipId = value;
        }
        String membershipId ;
    }

    @Value
    public static class MembershipName {
        public MembershipName(String value) {
            this.nameValue = value;
        }

        String nameValue;
    }

    @Value
    public static class MembershipEmail {
        public MembershipEmail(String value) {
            this.emailValue = value;
        }
        String emailValue;
    }

    @Value
    public static class MembershipAddress {
        public MembershipAddress(String value) {
            this.addressValue = value;
        }
        String addressValue;
    }

    @Value
    public static class MembershipIsValid {
        public MembershipIsValid(boolean value) {
            this.isValidValue = value;
        }
        boolean isValidValue;
    }

    @Value
    public static class MembershipAggregateIdentifier {
        public MembershipAggregateIdentifier(String value) {
            this.aggregateIdentifier = value;
        }
        String aggregateIdentifier;
    }
}
