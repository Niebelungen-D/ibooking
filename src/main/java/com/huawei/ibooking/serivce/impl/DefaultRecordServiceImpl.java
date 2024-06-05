package com.huawei.ibooking.serivce.impl;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.po.DefaultRecord;
import com.huawei.ibooking.bean.po.DefaultRecordExample;
import com.huawei.ibooking.bean.vo.defaultrecord.DefaultRecordInfo;
import com.huawei.ibooking.mgb.mapper.DefaultRecordMapper;
import com.huawei.ibooking.serivce.DefaultRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DefaultRecordServiceImpl implements DefaultRecordService {

    @Resource
    DefaultRecordMapper defaultRecordMapper;

    @Override
    public int insert(DefaultRecord record) {
        return defaultRecordMapper.insert(record);
    }

    @Override
    public PageInfo<DefaultRecordInfo> selectByExample(DefaultRecordExample example, Integer pageNum, Integer pageSize) {
        return null;
    }
}
