package com.huawei.ibooking.bean.dto.reservation;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CancelReservationRequest {

    Integer ReservationId;

    Integer userId;


}
