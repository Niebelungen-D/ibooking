package com.huawei.ibooking.serivce.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.Do.reservation.ReservationSQLResult;
import com.huawei.ibooking.bean.po.Reservation;
import com.huawei.ibooking.bean.po.ReservationExample;
import com.huawei.ibooking.bean.po.Studyroom;
import com.huawei.ibooking.bean.vo.reservation.ReservationInformation;
import com.huawei.ibooking.bean.vo.studyroom.StudyRoomInformation;
import com.huawei.ibooking.mgb.mapper.ReservationMapper;
import com.huawei.ibooking.serivce.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {


    @Autowired
    ReservationMapper reservationMapper;

    @Override
    public PageInfo<ReservationInformation> selectByExample(ReservationExample example, int pageNum, int pageSize, String sort) {
        PageHelper.startPage(pageNum, pageSize);
        example.setOrderByClause(sort);
        List<Reservation> reservations = reservationMapper.selectByExample(example);
        List<ReservationInformation> reservationInformationList = new ArrayList<>();
        reservations.stream()
                .map(reservation -> {
                    ReservationInformation info = new ReservationInformation();
                    info.setIsCheckin(reservation.getIsCheckin());
                    info.setStartTime(reservation.getStartTime());
                    info.setEndTime(reservation.getEndTime());
                    return info;
                })
                .forEach(reservationInformationList::add);
        return new PageInfo<>(reservationInformationList);
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
        return null;
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
        return 0;
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
        info.setBuildingName(sqlResult.getBuildingName()); // 假设building_id是教学楼ID
        info.setStudyroomNumber(sqlResult.getStudyroomId()); // 假设studyroom_id是自习室序号
        return info;
    }


}
