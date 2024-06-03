package com.huawei.ibooking.controller;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.enums.ResponseEnum;
import com.huawei.ibooking.bean.enums.CheckStatusEnum;
import com.huawei.ibooking.bean.po.CheckRecord;
import com.huawei.ibooking.bean.po.CheckRecordExample;
import com.huawei.ibooking.bean.vo.check.CheckInformation;
// import com.huawei.ibooking.bean.vo.studyroom.StudyRoomInformation;
import com.huawei.ibooking.commons.JsonResult;
// import com.huawei.ibooking.serivce.StudyroomService;
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
public class CheckController {

    @Autowired
    CheckRecordService checkRecordService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询签到状态", tags = "查询签到状态")
    public JsonResult<PageInfo<StudyRoomInformation>> getStudyRoomList(
            @ApiParam(required = false) @RequestParam(name = "reservationId", required = false) Boolean reservationId
    ) {
        CheckRecordExample checkRecordExample = new CheckRecordExample();
        CheckRecordExample.Criteria criteria = checkRecordExample.createCriteria();
        if (!ObjectUtils.isEmpty(reservationId)) {
            criteria.andReservationIdEqualTo(reservationId);
        }

        PageInfo<CheckRecordInformation> checkRecordInformationPageInfo = checkRecordService.selectByExample(checkRecordExample);
        return new JsonResult<>(checkRecordInformationPageInfo);

    }


    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ApiOperation(value = "进行签到", tags = "进行签到")
    public JsonResult<Object>update(
            @ApiParam(required = true) @RequestParam(name = "reservationId", required = true) Integer reservationId,
            @ApiParam(required = true) @RequestParam(name = "checktime", required = true) Boolean checktime
    ) {

        CheckRecordExample example = new CheckRecordExample();
        CheckRecordExample.Criteria criteria = example.createCriteria();
        criteria.andReservationIdEqualTo(reservationId);
        criteria.andCheckTimeEqualTo(checktime);
        CheckRecord checkRecord = new CheckRecord();
        checkRecord.setCheckTime(checktime);
        checkRecord.setReservationId(reservationId);
        int update = studyroomService.updateByExample(studyroom, example);
        if (update >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }
    }

}
