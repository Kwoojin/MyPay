package com.fc.banking.adapter.out.persistence.external.bank;

import lombok.Value;

@Value
public class FirmBankingResult {

    int resultCode; // 0: 성공, 1: 실패
}
