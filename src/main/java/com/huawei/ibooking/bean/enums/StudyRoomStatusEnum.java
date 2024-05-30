package com.huawei.ibooking.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StudyRoomStatusEnum {
    OPEN(true, "开启"),
    CLOSE(false, "关闭");

    private final Boolean status;

    private final String description;

}
