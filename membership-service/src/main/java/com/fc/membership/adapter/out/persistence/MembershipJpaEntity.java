package com.fc.membership.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "membership")
@Entity
public class MembershipJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membershipId;

    private String name;

    private String address;

    private String email;

    private boolean isValid;

    private boolean isCorp;

    public static MembershipJpaEntity of(String name, String address, String email, boolean isValid, boolean isCorp) {
        return new MembershipJpaEntity(null, name, address, email, isValid, isCorp);
    }

    public void updateMembership(String name, String address, String email, boolean isValid, boolean isCorp) {
        this.name = name ;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;
    }

    @Override
    public String toString() {
        return "MembershipJpaEntity{" +
                "membershipId=" + membershipId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", isValid=" + isValid +
                ", isCorp=" + isCorp +
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
