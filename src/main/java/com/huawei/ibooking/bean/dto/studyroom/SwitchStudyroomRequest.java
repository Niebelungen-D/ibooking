package com.huawei.ibooking.bean.dto.studyroom;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SwitchStudyroomRequest {

    Integer studyroomId;

    Boolean roomStatus;

}
