package com.fc.common;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class RechargingMoneyTask {

    String taskID;
    String taskName;

    String membershipID;

    List<SubTask> subTaskList;

    // 법인 계좌
    String toBankName;

    // 법인 계좌 번호
    String toBankAccountNumber;

    int moneyAmount; // only won

}
