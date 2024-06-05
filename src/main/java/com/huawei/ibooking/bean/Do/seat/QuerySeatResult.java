package com.huawei.ibooking.bean.Do.seat;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuerySeatResult {

    Integer seatId;

    Integer studyroomId;

    Boolean isBooking;

    Byte hasSocket;

    Integer seatNumber;

}
