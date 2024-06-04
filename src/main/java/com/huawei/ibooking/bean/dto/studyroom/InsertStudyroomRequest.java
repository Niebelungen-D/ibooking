package com.huawei.ibooking.bean.dto.studyroom;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InsertStudyroomRequest {

    Boolean roomStatus;

    Integer studyroomNumber;

    Integer buildingId;

}
