package com.huawei.ibooking.bean.dto.reservation;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.sql.Date;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InsertReservationRequest {

    @NotNull(message = "开始时间不能为空")
    @Future(message = "开始时间必须在当前时间之后")
    private Timestamp startTime;

    @NotNull(message = "结束时间不能为空")
    @Future(message = "结束时间必须在当前时间之后")
    @PastOrPresent(message = "结束时间必须在开始时间之前")
    private Timestamp endTime;

    @NotNull(message = "用户ID不能为空")
    @Min(value = 1, message = "用户ID必须为正整数")
    private Integer userId;

    @NotNull(message = "座位ID不能为空")
    @Min(value = 1, message = "座位ID必须为正整数")
    private Integer seatId;

    @NotNull(message = "建筑ID不能为空")
    @Min(value = 1, message = "建筑ID必须为正整数")
    private Integer buildingId;

    @NotNull(message = "学习室ID不能为空")
    @Min(value = 1, message = "学习室ID必须为正整数")
    private Integer studyroomId;


}
