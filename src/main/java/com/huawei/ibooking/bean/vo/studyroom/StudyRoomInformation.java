package com.huawei.ibooking.bean.vo.studyroom;

import lombok.*;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyRoomInformation {

    private Integer studyroomId;

    private Boolean roomStatus;

    private Integer studyroomNumber;

    private Integer buildingId;

}
