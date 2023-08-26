package com.fc.money.adapter.out.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "money_changing_request")
@Entity
public class MoneyChangingRequestJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moneyChangingRequestId;

    private String targetMembershipId;

    private int moneyChangingType; // 0: 증액, 1: 감액

    private int moneyAmount;

    private LocalDateTime timestamp;

    private int changingMoneyStatus; // 0: 요청, 1: 성공, 2: 실패

    private String uuid;

    public MoneyChangingRequestJpaEntity(String targetMembershipId, int moneyChangingType, int moneyAmount, LocalDateTime timestamp, int changingMoneyStatus, UUID uuid) {
        this.targetMembershipId = targetMembershipId;
        this.moneyChangingType = moneyChangingType;
        this.moneyAmount = moneyAmount;
        this.timestamp = timestamp;
        this.changingMoneyStatus = changingMoneyStatus;
        this.uuid = uuid.toString();
    }


    @Override
    public String toString() {
        return "MoneyChangingRequestJpaEntity{" +
                "moneyChangingRequestId=" + moneyChangingRequestId +
                ", targetMembershipId='" + targetMembershipId + '\'' +
                ", moneyChangingType=" + moneyChangingType +
                ", moneyAmount=" + moneyAmount +
                ", timestamp=" + timestamp +
                ", changingMoneyStatus=" + changingMoneyStatus +
                ", uuid='" + uuid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoneyChangingRequestJpaEntity)) return false;
        MoneyChangingRequestJpaEntity that = (MoneyChangingRequestJpaEntity) o;
        return this.getMoneyChangingRequestId() != null && this.getMoneyChangingRequestId().equals(that.getMoneyChangingRequestId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMoneyChangingRequestId());
    }


}
