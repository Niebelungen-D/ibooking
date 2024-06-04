package com.huawei.ibooking.serivce.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.enums.CheckStatusEnum;
import com.huawei.ibooking.bean.po.CheckRecord;
import com.huawei.ibooking.bean.po.CheckRecordExample;
import com.huawei.ibooking.bean.po.Reservation;
import com.huawei.ibooking.bean.po.ReservationExample;
import com.huawei.ibooking.bean.vo.reservation.ReservationInformation;
import com.huawei.ibooking.mgb.mapper.CheckRecordMapper;
import com.huawei.ibooking.mgb.mapper.ReservationMapper;
import com.huawei.ibooking.serivce.CheckRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class CheckRecordServiceImpl implements CheckRecordService {

    @Resource
    CheckRecordMapper checkRecordMapper;

    @Resource
    ReservationMapper reservationMapper;
    @Override
    public PageInfo<CheckRecord> selectByExample(CheckRecordExample example, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CheckRecord> checkRecords = checkRecordMapper.selectByExample(example);
        return new PageInfo<>(checkRecords);
    }

    @Override
    public int insert(CheckRecord record) {
        return 0;
    }

    @Override
    public int insertSelective(CheckRecord record) {
        return 0;
    }

    @Override
    public CheckRecord selectByPrimaryKey(Integer uuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(CheckRecord record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(CheckRecord record) {
        return 0;
    }

    @Override
    public int updateByExample(CheckRecord record, CheckRecordExample example) {
        return 0;
    }

    @Override
    public int updateByExampleSelective(CheckRecord record, CheckRecordExample example) {
        return 0;
    }

    @Override
    public long countByExample(CheckRecordExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(CheckRecordExample example) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class) // 声明事务，并指定回滚异常类型
    public Boolean checkRecord(Integer reservationId) {

        ReservationExample reservationExample = new ReservationExample();
        ReservationExample.Criteria criteria = reservationExample.createCriteria();
        criteria.andRIdEqualTo(reservationId);

        Reservation reservation = new Reservation();
        reservation.setIsCheckin(CheckStatusEnum.OPEN.getStatus());
        int update = reservationMapper.updateByExampleSelective(reservation, reservationExample);

        CheckRecord checkRecord = new CheckRecord();
        Calendar calendar = Calendar.getInstance();
        // 从Calendar实例获取当前时间的java.util.Date对象
        java.util.Date utilDate = calendar.getTime();
        checkRecord.setCheckTime(utilDate);
        checkRecord.setReservationId(reservationId);

        int insert = checkRecordMapper.insert(checkRecord);

        return insert >=1 && update >= 1;

    }
}
