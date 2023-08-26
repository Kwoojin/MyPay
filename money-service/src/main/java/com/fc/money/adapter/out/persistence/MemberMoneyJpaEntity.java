package com.fc.money.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member_money")
@Entity
public class MemberMoneyJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberMoneyId;

    private Long membershipId;

    private int balance;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public MemberMoneyJpaEntity(Long membershipId, int balance) {
        this.membershipId = membershipId;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberMoneyJpaEntity)) return false;
        MemberMoneyJpaEntity that = (MemberMoneyJpaEntity) o;
        return this.getMemberMoneyId() != null && this.getMemberMoneyId().equals(that.getMemberMoneyId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMemberMoneyId());
    }
}
