package com.huawei.ibooking.serivce;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.po.CheckRecord;
import com.huawei.ibooking.bean.po.CheckRecordExample;

public interface CheckRecordService {

    PageInfo<CheckRecord> selectByExample(CheckRecordExample example, Integer pageNum, Integer pageSize);

    int insert(CheckRecord record);

    int insertSelective(CheckRecord record);

    CheckRecord selectByPrimaryKey(Integer uuid);

    int updateByPrimaryKeySelective(CheckRecord record);

    int updateByPrimaryKey(CheckRecord record);

    int updateByExample(CheckRecord record, CheckRecordExample example);

    int updateByExampleSelective(CheckRecord record, CheckRecordExample example);

    long countByExample(CheckRecordExample example);

    int deleteByExample(CheckRecordExample example);

    Boolean checkRecord(Integer reservationId);

}
