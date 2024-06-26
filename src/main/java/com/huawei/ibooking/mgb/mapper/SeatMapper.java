package com.huawei.ibooking.mgb.mapper;

import com.huawei.ibooking.bean.Do.seat.QuerySeatResult;
import com.huawei.ibooking.bean.po.Seat;
import com.huawei.ibooking.bean.po.SeatExample;

import java.sql.Timestamp;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeatMapper {
    long countByExample(SeatExample example);

    int deleteByExample(SeatExample example);

    int deleteByPrimaryKey(Integer seatId);

    int insert(Seat row);

    int insertSelective(Seat row);

    List<Seat> selectByExample(SeatExample example);

    Seat selectByPrimaryKey(Integer seatId);

    int updateByExampleSelective(@Param("row") Seat row, @Param("example") SeatExample example);

    int updateByExample(@Param("row") Seat row, @Param("example") SeatExample example);

    int updateByPrimaryKeySelective(Seat row);

    int updateByPrimaryKey(Seat row);

    List<QuerySeatResult> getSeatBookingStatus(@Param("studyroomId") Integer studyroomId, @Param("startTime") Timestamp startTime);


    List<QuerySeatResult> selectSeatsAndBookingStatus(@Param("studyroomId") Integer studyroomId, @Param("startTime") Timestamp startTime);

}