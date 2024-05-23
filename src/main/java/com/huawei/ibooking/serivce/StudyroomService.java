package com.huawei.ibooking.serivce;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.po.Studyroom;
import com.huawei.ibooking.bean.po.StudyroomExample;
import com.huawei.ibooking.bean.vo.studyroom.StudyRoomInformation;

public interface StudyroomService {

    PageInfo<StudyRoomInformation> selectByExample(StudyroomExample example, int pageNum, int pageSize, String sort);

    int insert(Studyroom record);

    int insertSelective(Studyroom record);

    Studyroom selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(Studyroom record);

    int updateByPrimaryKey(Studyroom record);

    int updateByExample(Studyroom record, StudyroomExample example);

    int updateByExampleSelective(Studyroom record, StudyroomExample example);

    long countByExample(StudyroomExample example);

    int deleteByExample(StudyroomExample example);



}
