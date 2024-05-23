package com.huawei.ibooking.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum {

    ADMIN(1, "管理员"),
    NORMAL_USER(0, "普通用户");

    private final Integer code;

    private final String description;

}
