package com.huawei.ibooking.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SeatStatusEnum {
    OPEN(true, "桌位已预约"),
    CLOSE(false, "桌位未预约");

    private final Boolean status;

    private final String description;

}