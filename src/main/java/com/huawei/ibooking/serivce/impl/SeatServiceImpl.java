package com.huawei.ibooking.serivce.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.po.Seat;
import com.huawei.ibooking.bean.po.SeatExample;
import com.huawei.ibooking.bean.vo.Seat.SeatInformation;
import com.huawei.ibooking.mgb.mapper.SeatMapper;
import com.huawei.ibooking.serivce.SeatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Resource
    SeatMapper seatMapper;
    @Override
    public PageInfo<SeatInformation> selectByExample(SeatExample example, Integer pageNum, Integer pageSize, String sort) {
        PageHelper.startPage(pageNum, pageSize);
        example.setOrderByClause(sort);
        List<Seat> seatList = seatMapper.selectByExample(example);
        List<SeatInformation> seatInformationList = new ArrayList<>();
        seatList.stream()
                .map(seat -> {
                    SeatInformation information = new SeatInformation();
                    information.setSeatId(seat.getSeatId());
                    information.setStudyroomId(seat.getStudyroomId());
                    information.setHasSocket(seat.getHasSocket());
                    return information;
                })
                .forEach(seatInformationList::add);
        return new PageInfo<>(seatInformationList);
    }

    @Override
    public int insert(Seat seat) {
        return seatMapper.insert(seat);
    }

    @Override
    public int insertSelective(Seat seat) {
        return 0;
    }

    @Override
    public Seat selectByPrimaryKey(Integer uuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Seat seat) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Seat seat) {
        return 0;
    }

    @Override
    public int updateByExample(Seat seat, SeatExample example) {
        return seatMapper.updateByExample(seat, example);
    }

    @Override
    public int updateByExampleSelective(Seat seat, SeatExample example) {
        return seatMapper.updateByExampleSelective(seat, example);
    }

    @Override
    public long countByExample(SeatExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(SeatExample example) {
        return 0;
    }
}
