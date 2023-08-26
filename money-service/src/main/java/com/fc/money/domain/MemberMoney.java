package com.fc.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMoney {

    private final String memberMoneyId;

    private final String membershipId;

    // 잔액
    private final int balance;


    public static MemberMoney generateMemberMoney(
            MemberMoneyId memberMoneyId,
            MembershipId membershipId,
            MoneyBalance moneyBalance
    ){
        return new MemberMoney(
                memberMoneyId.memberMoneyId,
                membershipId.membershipId,
                moneyBalance.balance
        );
    }

    @Value
    public static class MemberMoneyId {
        String memberMoneyId ;
    }

    @Value
    public static class MembershipId {
        String membershipId ;
    }

    @Value
    public static class MoneyBalance {
        int balance ;
    }
}
