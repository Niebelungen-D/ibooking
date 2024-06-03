package com.huawei.ibooking.bean.vo.checkrecord;

import lombok.*;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyRoomInformation {

    private Boolean checkStatus;

    private Integer checkTime;

    private Integer reservationId;

}
