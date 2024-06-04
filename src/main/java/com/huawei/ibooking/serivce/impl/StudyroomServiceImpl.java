package com.huawei.ibooking.serivce.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.po.Studyroom;
import com.huawei.ibooking.bean.po.StudyroomExample;
import com.huawei.ibooking.bean.vo.studyroom.StudyRoomInformation;
import com.huawei.ibooking.mgb.mapper.StudyroomMapper;
import com.huawei.ibooking.serivce.StudyroomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudyroomServiceImpl implements StudyroomService {


    @Resource
    private StudyroomMapper studyroomMapper;

    @Override
    public PageInfo<StudyRoomInformation> selectByExample(StudyroomExample example, int pageNum, int pageSize, String sort) {
        PageHelper.startPage(pageNum, pageSize);
        example.setOrderByClause(sort);
        List<Studyroom> studyroomList = studyroomMapper.selectByExample(example);
        List<StudyRoomInformation> studyRoomInformationList = new ArrayList<>();
        studyroomList.stream()
                .map(studyroom -> {
                    StudyRoomInformation info = new StudyRoomInformation();
                    info.setRoomStatus(studyroom.getRoomStatus());
                    info.setStudyroomNumber(studyroom.getStudyroomNumber());
                    info.setBuildingId(studyroom.getBuildingId());
                    info.setStudyroomId(studyroom.getStudyroomId());
                    return info;
                })
                .forEach(studyRoomInformationList::add);
        return new PageInfo<>(studyRoomInformationList);
    }

    @Override
    public int insert(Studyroom record) {
        return studyroomMapper.insert(record);
    }

    @Override
    public int insertSelective(Studyroom record) {
        return studyroomMapper.insertSelective(record);
    }

    @Override
    public Studyroom selectByPrimaryKey(Integer uuid) {
        return studyroomMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Studyroom record) {
        return studyroomMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Studyroom record) {
        return studyroomMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByExample(Studyroom record, StudyroomExample example) {
        return studyroomMapper.updateByExample(record, example);
    }

    @Override
    public int updateByExampleSelective(Studyroom record, StudyroomExample example) {
        return studyroomMapper.updateByExampleSelective(record, example);
    }

    @Override
    public long countByExample(StudyroomExample example) {
        return studyroomMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(StudyroomExample example) {
        return studyroomMapper.deleteByExample(example);
    }
}
