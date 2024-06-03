package com.huawei.ibooking.bean.dto.seat;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SwitchSeatRequest {

    Integer seatId;

    Byte hasSocket;

}
