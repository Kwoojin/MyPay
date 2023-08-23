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
@Table(name = "request_firm_banking")
@Entity
public class FirmBankingRequestJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestFirmBankingId;

    private String fromBankName;

    private String fromBankAccountNumber;

    private String toBankName;

    private String toBankAccountNumber;

    private int moneyAmount;

    private int firmBankingStatus; // 0:요청, 1:완료, 2:실패

    private String uuid;

    public static FirmBankingRequestJpaEntity of(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, int moneyAmount, int firmBankingStatus, String uuid) {
        return new FirmBankingRequestJpaEntity(null, fromBankName, fromBankAccountNumber, toBankName, toBankAccountNumber, moneyAmount, firmBankingStatus, uuid);
    }

    public void updateFirmBankingStatus(int firmBankingStatus, String uuid) {
        this.firmBankingStatus = firmBankingStatus;
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FirmBankingRequestJpaEntity)) return false;
        FirmBankingRequestJpaEntity that = (FirmBankingRequestJpaEntity) o;
        return this.getRequestFirmBankingId() != null && this.getRequestFirmBankingId().equals(that.getRequestFirmBankingId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestFirmBankingId());
    }


}
