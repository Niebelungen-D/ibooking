package com.huawei.ibooking.serivce;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.po.Seat;
import com.huawei.ibooking.bean.po.SeatExample;
import com.huawei.ibooking.bean.vo.Seat.SeatInformation;

public interface SeatService {

    PageInfo<SeatInformation> selectByExample(SeatExample example);

    int insert(Seat seat);

    int insertSelective(Seat seat);

    Seat selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Seat seat);

    int updateByPrimaryKey(Seat seat);

    int updateByExample(Seat seat, SeatExample example);

    int updateByExampleSelective(Seat seat, SeatExample example);

    long countByExample(SeatExample example);

    int deleteByExample(SeatExample example);

}