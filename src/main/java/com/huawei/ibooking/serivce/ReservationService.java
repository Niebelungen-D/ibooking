package com.huawei.ibooking.serivce;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.Do.reservation.ReservationSQLResult;
import com.huawei.ibooking.bean.po.Reservation;
import com.huawei.ibooking.bean.po.ReservationExample;
import com.huawei.ibooking.bean.vo.reservation.ReservationInformation;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ReservationService {

    PageInfo<Reservation> selectByExample(ReservationExample example, int pageNum, int pageSize, String sort);

    int insert(Reservation record);

    int insertSelective(Reservation record);

    Reservation selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Reservation record);

    int updateByPrimaryKey(Reservation record);

    int updateByExample(Reservation record, ReservationExample example);

    long countByExample(ReservationExample example);

    int deleteByExample(ReservationExample example);

    /**
     * 根据条件查询所有预订信息
     * @param userName 用户名
     * @param buildingName 建筑名称
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param pageNum 页数
     * @param pageSize 页码
     * @param orderByClause 排序子句
     * @return 预订信息列表
     */
    PageInfo<ReservationInformation> selectAllReservationsByCondition(
            String userName,
            String buildingName,
            String startTime,
            String endTime,
            int pageNum,
            int pageSize,
            String orderByClause);


    Boolean isReservationAvailable(Integer seatId, Timestamp startTime, Timestamp endTime);

    Boolean makeReservation(Integer buildingId, Integer seatId, Timestamp startTime, Timestamp endTime, Integer studyroomId, Integer userId);


    List<Reservation> listAllReservation(ReservationExample example);

}
