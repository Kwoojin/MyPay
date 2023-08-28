package com.fc.money.application.port.out;

public interface GetMembershipPort {
    MembershipStatus getMembership(String membershipId);
}
