package com.huawei.ibooking.bean.dto.seat;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InsertSeatRequest {

    private Byte hasSocket;

    private Integer studyroomId;

}
