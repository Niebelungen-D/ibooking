package com.huawei.ibooking.serivce;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.Do.seat.QuerySeatResult;
import com.huawei.ibooking.bean.po.Seat;
import com.huawei.ibooking.bean.po.SeatExample;
import com.huawei.ibooking.bean.vo.Seat.SeatInformation;

import java.sql.Timestamp;
import java.util.List;

public interface SeatService {

    PageInfo<SeatInformation> selectByExample(SeatExample example, Integer pageNum, Integer pageSize, String sort);

    int insert(Seat seat);

    int insertSelective(Seat seat);

    Seat selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Seat seat);

    int updateByPrimaryKey(Seat seat);

    int updateByExample(Seat seat, SeatExample example);

    int updateByExampleSelective(Seat seat, SeatExample example);

    long countByExample(SeatExample example);

    int deleteByExample(SeatExample example);


    List<QuerySeatResult> getSeatBookingStatus(Integer studyroomId, Timestamp startTime);

}