package com.huawei.ibooking.bean.dto.checkrecord;


import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CheckRequest {

    @NotNull(message = "预约ID不能为空")
    @Min(value = 1, message = "预约ID必须为正整数")
    Integer rId;

    @NotNull(message = "用户ID不能为空")
    @Min(value = 1, message = "用户ID必须为正整数")
    Integer userId;

}
