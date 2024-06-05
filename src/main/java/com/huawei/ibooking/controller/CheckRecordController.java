package com.huawei.ibooking.controller;


import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.dto.checkrecord.CheckRequest;
import com.huawei.ibooking.bean.enums.ResponseEnum;
import com.huawei.ibooking.bean.po.CheckRecord;
import com.huawei.ibooking.bean.po.CheckRecordExample;
import com.huawei.ibooking.bean.po.Reservation;
import com.huawei.ibooking.bean.po.ReservationExample;
import com.huawei.ibooking.commons.JsonResult;
import com.huawei.ibooking.serivce.CheckRecordService;
import com.huawei.ibooking.serivce.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/check")
@Api(value = "签到管理", tags = {"用户端签到管理"})
public class CheckRecordController {

    @Autowired
    CheckRecordService checkRecordService;

    @Autowired
    ReservationService reservationService;

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

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ApiOperation(value = "签到", tags = "用户签到")
    public JsonResult<Object> checkRecord(
            @ApiParam(required = true) @RequestBody CheckRequest checkRequest
    ) {
        Integer userId = checkRequest.getUserId();
        Integer rId = checkRequest.getReservationId();
        if (ObjectUtils.isEmpty(userId) || ObjectUtils.isEmpty(rId)) {
            return new JsonResult<>(ResponseEnum.BAD_REQUEST);
        }

        ReservationExample reservationExample = new ReservationExample();
        ReservationExample.Criteria criteria = reservationExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andRIdEqualTo(rId);
        Reservation reservation = reservationService.selectByPrimaryKey(rId);
        if (ObjectUtils.isEmpty(reservation)) {
            return new JsonResult<>(ResponseEnum.RESERVATION_NOT_EXIST);
        }

        // 获取当前日期
        LocalDate today = LocalDate.now();

        // 使用上海时区
        ZoneId shanghaiZone = ZoneId.of("Asia/Shanghai");

        // 获取当天的开始时间
        ZonedDateTime startOfDayInShanghai = today.atStartOfDay(shanghaiZone);

        // 获取当天的结束时间 23:59:59.999
        LocalTime endOfDay = LocalTime.of(23, 59, 59, 999_999_999);
        ZonedDateTime endOfDayInShanghai = ZonedDateTime.of(today, endOfDay, shanghaiZone);

        // 转换为Instant并获取时间戳
        long startOfDayInstant = startOfDayInShanghai.toInstant().toEpochMilli();
        long endOfDayInstant = endOfDayInShanghai.toInstant().toEpochMilli();
        if (!(reservation.getStartTime().getTime() <= endOfDayInstant && reservation.getStartTime().getTime() >= startOfDayInstant)) {
            return new JsonResult<>("3000", "您今天没有预约");
        }

        if (checkRecordService.checkRecord(rId)) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }
    }

}
