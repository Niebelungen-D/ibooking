package com.huawei.ibooking.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SeatStatusEnum {
    OPEN((byte) 1, "桌位已预约"),
    CLOSE((byte) 0, "桌位未预约");

    private final Byte status;

    private final String description;

}