package com.huawei.ibooking.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CheckStatusEnum {
    OPEN(true, "已签到"),
    CLOSE(false, "未签到");

    private final Boolean status;

    private final String description;

}
