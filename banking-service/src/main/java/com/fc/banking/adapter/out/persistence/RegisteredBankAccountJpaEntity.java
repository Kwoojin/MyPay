package com.fc.banking.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "registered_bank_account")
@Entity
public class RegisteredBankAccountJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registeredBankAccountId;

    private Long memberShipId;

    private String bankName;

    private String bankAccountNumber;

    private boolean linkedStatusIsValid;

    public static RegisteredBankAccountJpaEntity of(Long memberShipId, String bankName, String bankAccountNumber, boolean linkedStatusIsValid) {
        return new RegisteredBankAccountJpaEntity(null, memberShipId, bankName, bankAccountNumber, linkedStatusIsValid);
    }


    @Override
    public String toString() {
        return "RegisteredBankAccountJpaEntity{" +
                "registeredBankAccountId=" + registeredBankAccountId +
                ", memberShipId='" + memberShipId + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", linkedStatusIsValid=" + linkedStatusIsValid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisteredBankAccountJpaEntity)) return false;
        RegisteredBankAccountJpaEntity that = (RegisteredBankAccountJpaEntity) o;
        return this.getRegisteredBankAccountId() != null && this.getRegisteredBankAccountId().equals(that.getRegisteredBankAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegisteredBankAccountId());
    }


}
