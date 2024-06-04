package com.huawei.ibooking.mgb.mapper;

import com.huawei.ibooking.bean.Do.reservation.ReservationSQLResult;
import com.huawei.ibooking.bean.po.Reservation;
import com.huawei.ibooking.bean.po.ReservationExample;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReservationMapper {
    long countByExample(ReservationExample example);

    int deleteByExample(ReservationExample example);

    int deleteByPrimaryKey(Integer rId);

    int insert(Reservation row);

    int insertSelective(Reservation row);

    List<Reservation> selectByExample(ReservationExample example);

    Reservation selectByPrimaryKey(Integer rId);

    int updateByExampleSelective(@Param("row") Reservation row, @Param("example") ReservationExample example);

    int updateByExample(@Param("row") Reservation row, @Param("example") ReservationExample example);

    int updateByPrimaryKeySelective(Reservation row);

    int updateByPrimaryKey(Reservation row);

    List<ReservationSQLResult> selectAllReservationsByCondition(
            @Param("userName") String userName,
            @Param("buildingName") String buildingName,
            @Param("startTime") String startTime,
            @Param("endTime") String endTime,
            @Param("orderByClause") String orderByClause);


    int countConflictingReservations(@Param("seatId") Integer seatId,
                                     @Param("startTime") Timestamp startTime,
                                     @Param("endTime") Timestamp endTime,
                                     @Param("hasSocket") Byte hasSocket);
}