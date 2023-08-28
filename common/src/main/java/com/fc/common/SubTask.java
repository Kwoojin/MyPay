package com.fc.common;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubTask {
    private final String membershipID;
    private final String subTaskName;
    private final String taskType;        // "banking", "membership"
    private String status;          // "success", "fail", "ready"

    public void setStatus(String status) {
        this.status = status;
    }
}
