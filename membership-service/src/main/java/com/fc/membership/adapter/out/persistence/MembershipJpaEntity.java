package com.fc.membership.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class MembershipJpaEntity {

    @Id
    @GeneratedValue
    private Long membershipId;

    private String name;

    private String address;

    private String email;

    private boolean isValid;

    private String aggregateIdentifier;

    public static MembershipJpaEntity of(String name, String address, String email, boolean isValid, String aggregateIdentifier) {
        return new MembershipJpaEntity(null, name, address, email, isValid, aggregateIdentifier);
    }

    @Override
    public String toString() {
        return "MembershipJpaEntity{" +
                "membershipId=" + membershipId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", isValid=" + isValid +
                ", aggregateIdentifier=" + aggregateIdentifier +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MembershipJpaEntity)) return false;
        MembershipJpaEntity that = (MembershipJpaEntity) o;
        return this.getMembershipId() != null && this.getMembershipId().equals(that.getMembershipId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMembershipId());
    }


}
