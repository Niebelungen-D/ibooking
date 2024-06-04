package com.huawei.ibooking.bean.Do.reservation;

import lombok.*;

import java.sql.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationSQLResult {

    private Integer reservationId;
    private Date startTime;
    private Date endTime;
    private Boolean isCheckin;
    private Integer seatId;
    private Boolean hasSocket;
    private Integer userId;
    private String userName;
    private String userEmail;
    private Integer buildingId;
    private String buildingName;
    private Integer studyroomId;
    private String roomStatus;
    private String studyroomNumber;

}
