package com.fc.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FirmBankingRequest {

    private final String firmBankingRequestId;

    private final String fromBankName;

    private final String fromBankAccountNumber;

    private final String toBankName;

    private final String toBankAccountNumber;

    private final int moneyAmount;

    private final int firmBankingStatus; // 0:요청, 1:완료, 2:실패

    private final String uuid;

    public static FirmBankingRequest generateFirmBankingRequest(
           FirmBankingRequestId firmBankingRequestId,
           FromBankName fromBankName,
           FromBankAccountNumber fromBankAccountNumber,
           ToBankName toBankName,
           ToBankAccountNumber toBankAccountNumber,
           MoneyAmount moneyAmount,
           FirmBankingStatus firmBankingStatus,
           Uuid uuid
    ) {
        return new FirmBankingRequest(
                firmBankingRequestId.firmBankingRequestId,
                fromBankName.fromBankName,
                fromBankAccountNumber.fromBankAccountNumber,
                toBankName.toBankName,
                toBankAccountNumber.toBankAccountNumber,
                moneyAmount.moneyAmount,
                firmBankingStatus.firmBankingStatus,
                uuid.uuid
        );
    }

    @Value
    public static class FirmBankingRequestId {
        String firmBankingRequestId ;
    }

    @Value
    public static class FromBankName {
        String fromBankName;
    }


    @Value
    public static class FromBankAccountNumber {
        String fromBankAccountNumber;
    }

    @Value
    public static class ToBankName {
        String toBankName;
    }

    @Value
    public static class ToBankAccountNumber {
        String toBankAccountNumber;
    }

    @Value
    public static class MoneyAmount {
        int moneyAmount;
    }

    @Value
    public static class FirmBankingStatus {
        int firmBankingStatus;
    }

    @Value
    public static class Uuid {
        String uuid;
    }



}
