package com.huawei.ibooking.serivce.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.Do.reservation.ReservationSQLResult;
import com.huawei.ibooking.bean.enums.CheckStatusEnum;
import com.huawei.ibooking.bean.enums.SeatStatusEnum;
import com.huawei.ibooking.bean.po.*;
import com.huawei.ibooking.bean.vo.reservation.ReservationInformation;
import com.huawei.ibooking.bean.vo.studyroom.StudyRoomInformation;
import com.huawei.ibooking.mgb.mapper.ReservationMapper;
import com.huawei.ibooking.mgb.mapper.SeatMapper;
import com.huawei.ibooking.serivce.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {


    @Autowired
    ReservationMapper reservationMapper;

    @Autowired
    SeatMapper seatMapper;

    @Override
    public PageInfo<Reservation> selectByExample(ReservationExample example, int pageNum, int pageSize, String sort) {
        PageHelper.startPage(pageNum, pageSize);
        example.setOrderByClause(sort);
        List<Reservation> reservations = reservationMapper.selectByExample(example);
        return new PageInfo<>(reservations);
    }

    @Override
    public int insert(Reservation record) {
        return reservationMapper.insert(record);
    }

    @Override
    public int insertSelective(Reservation record) {
        return 0;
    }

    @Override
    public Reservation selectByPrimaryKey(Integer uuid) {
        return reservationMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Reservation record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Reservation record) {
        return 0;
    }

    @Override
    public int updateByExample(Reservation record, ReservationExample example) {
        return 0;
    }

    @Override
    public long countByExample(ReservationExample example) {
        return reservationMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ReservationExample example) {
        return 0;
    }

    @Override
    public PageInfo<ReservationInformation> selectAllReservationsByCondition(String userName, String buildingName, String startTime, String endTime, int pageNum, int pageSize, String orderByClause) {
        PageHelper.startPage(pageNum, pageSize);
        List<ReservationInformation> reservationInformationList = convertToReservationInformationList(reservationMapper.selectAllReservationsByCondition(
                userName,
                buildingName,
                startTime,
                endTime,
                orderByClause));
        return new PageInfo<>(reservationInformationList);
    }

    @Override
    public Boolean isReservationAvailable(Integer seatId, Timestamp startTime, Timestamp endTime) {
        return reservationMapper.countConflictingReservations(seatId, startTime, endTime, (byte) 1) == 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class) // 声明事务，并指定回滚异常类型
    public Boolean makeReservation(Integer buildingId, Integer seatId, Timestamp startTime, Timestamp endTime, Integer studyroomId, Integer userId) {

        SeatExample example = new SeatExample();
        SeatExample.Criteria criteria = example.createCriteria();
        criteria.andSeatIdEqualTo(seatId);
        criteria.andStudyroomIdEqualTo(studyroomId);

        Seat seat = new Seat();
        seat.setHasSocket(SeatStatusEnum.OPEN.getStatus());
        int update = seatMapper.updateByExampleSelective(seat, example);

        Reservation reservation = new Reservation();
        reservation.setBuildingId(buildingId);
        reservation.setSeatId(seatId);
        reservation.setIsCheckin(CheckStatusEnum.CLOSE.getStatus());
        reservation.setStartTime(startTime);
        reservation.setEndTime(endTime);
        reservation.setStudyroomId(studyroomId);
        reservation.setUserId(userId);
        int insert = reservationMapper.insert(reservation);

        return update >=1 && insert >= 1;
    }

    private List<ReservationInformation> convertToReservationInformationList(List<ReservationSQLResult> sqlResults) {
        return sqlResults.stream()
                .map(this::convertToReservationInformation)
                .collect(Collectors.toList());
    }

    private ReservationInformation convertToReservationInformation(ReservationSQLResult sqlResult) {
        if (sqlResult == null) {
            return null;
        }
        ReservationInformation info = new ReservationInformation();
        info.setUsername(sqlResult.getUserName());
        info.setStartTime(sqlResult.getStartTime() == null ? null : new Date(sqlResult.getStartTime().getTime()));
        info.setEndTime(sqlResult.getEndTime() == null ? null : new Date(sqlResult.getEndTime().getTime()));
        info.setIsCheckin(sqlResult.getIsCheckin());
        info.setBuildingName(sqlResult.getBuildingName());
        info.setStudyroomNumber(sqlResult.getStudyroomId());
        return info;
    }


}
