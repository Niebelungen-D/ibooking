package com.huawei.ibooking.controller;


import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.dto.checkrecord.CheckRequest;
import com.huawei.ibooking.bean.enums.ResponseEnum;
import com.huawei.ibooking.bean.po.CheckRecord;
import com.huawei.ibooking.bean.po.CheckRecordExample;
import com.huawei.ibooking.commons.JsonResult;
import com.huawei.ibooking.serivce.CheckRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/check")
@Api(value = "签到管理", tags = {"用户端签到管理"})
public class CheckRecordController {

    @Autowired
    CheckRecordService checkRecordService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询签到状态", tags = "查询签到状态")
    public JsonResult<PageInfo<CheckRecord>> getCheckRecordList(
            @ApiParam(required = false) @RequestParam(name = "rId", required = false) Integer rId,
            @ApiParam(required = false) @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @ApiParam(required = false) @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize
    ) {
        CheckRecordExample checkRecordExample = new CheckRecordExample();
        CheckRecordExample.Criteria criteria = checkRecordExample.createCriteria();
        if (!ObjectUtils.isEmpty(rId)) {
            criteria.andReservationIdEqualTo(rId);
        }

        PageInfo<CheckRecord> checkRecordInformationPageInfo = checkRecordService.selectByExample(checkRecordExample, pageNum, pageSize);
        return new JsonResult<>(checkRecordInformationPageInfo);

    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ApiOperation(value = "签到", tags = "用户签到")
    public JsonResult<Object> checkRecord(
            @ApiParam(required = true) @RequestBody CheckRequest checkRequest
    ) {
        Integer userId = checkRequest.getUserId();
        Integer rId = checkRequest.getRId();
        if (ObjectUtils.isEmpty(userId) || ObjectUtils.isEmpty(rId)) {
            return new JsonResult<>(ResponseEnum.BAD_REQUEST);
        }

        CheckRecordExample checkRecordExample = new CheckRecordExample();
        CheckRecordExample.Criteria criteria = checkRecordExample.createCriteria();
        criteria.andReservationIdEqualTo(rId);

        long count = checkRecordService.countByExample(checkRecordExample);
        if (count >=1) {
            return new JsonResult<>(ResponseEnum.RESERVATION_CHECKED);
        }

        if (checkRecordService.checkRecord(rId)) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }
    }

}
