package com.huawei.ibooking.serivce;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.po.DefaultRecord;
import com.huawei.ibooking.bean.po.DefaultRecordExample;
import com.huawei.ibooking.bean.vo.defaultrecord.DefaultRecordInfo;

public interface DefaultRecordService {

    int insert(DefaultRecord record);

    PageInfo<DefaultRecordInfo> selectByExample(DefaultRecordExample example, Integer pageNum, Integer pageSize);

}
