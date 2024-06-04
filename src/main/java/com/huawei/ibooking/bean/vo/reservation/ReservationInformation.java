package com.huawei.ibooking.bean.vo.reservation;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class ReservationInformation {

    // 预约ID
    private Integer rId;

    //预约人用户名
    private String username;

    //开始时间
    private Date startTime;

    //结束时间
    private Date endTime;

    //是否签到
    private Boolean isCheckin;

    //教学楼ID
    private String buildingName;

    //自习室序号
    private Integer studyroomNumber;

}
