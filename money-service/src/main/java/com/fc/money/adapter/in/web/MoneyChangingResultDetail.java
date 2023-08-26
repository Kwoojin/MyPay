package com.fc.money.adapter.in.web;

import lombok.Value;

@Value
public class MoneyChangingResultDetail {

    String moneyChangingRequestId;

    // 증액, 감액
    int moneyChangingType; // 0: 증액, 1: 감액
    int moneyChangingResultStatus; // 0: 성공, 실패, 실패 - 잔액 부족, 실패 - 멤버십 없음, 실패 - 머니 변액 요청 없음
    int amount;

}
