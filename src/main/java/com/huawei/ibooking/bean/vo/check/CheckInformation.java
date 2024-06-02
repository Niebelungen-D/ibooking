package com.huawei.ibooking.bean.vo.checkrecord;

import lombok.*;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckInformation {

    private Boolean checkStatus;

    private Integer checkTime;

    private Integer reservationId;

}
