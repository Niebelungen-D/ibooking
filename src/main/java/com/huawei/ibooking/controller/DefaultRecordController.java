package com.huawei.ibooking.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.enums.CheckStatusEnum;
import com.huawei.ibooking.bean.enums.ResponseEnum;
import com.huawei.ibooking.bean.po.DefaultRecord;
import com.huawei.ibooking.bean.po.Reservation;
import com.huawei.ibooking.bean.po.ReservationExample;
import com.huawei.ibooking.bean.vo.defaultrecord.DefaultRecordInfo;
import com.huawei.ibooking.commons.JsonResult;
import com.huawei.ibooking.serivce.DefaultRecordService;
import com.huawei.ibooking.serivce.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/violation")
@Api(value = "违规管理", tags = {"管理员端违规管理"})
public class DefaultRecordController {

    @Autowired
    DefaultRecordService defaultRecordService;

    @Autowired
    ReservationService reservationService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "管理员查询所有违规预约", tags = "管理员查询预约")
    public PageInfo<Reservation> query(
            @ApiParam(required = false) @RequestParam(value = "userId", required = true) Integer userId,
            @ApiParam(required = false) @RequestParam(value = "rId", required = false) Integer rId,
            @ApiParam(required = false) @RequestParam(value = "seatId", required = false) Integer seatId,
            @ApiParam(required = false) @RequestParam(value = "startTime", required = false) Timestamp startTime,
            @ApiParam(required = false) @RequestParam(value = "endTime", required = false) Timestamp endTime,
            @ApiParam(required = false) @RequestParam(value = "buildingId", required = false) Integer buildingId,
            @ApiParam(required = false) @RequestParam(value = "studyroomId", required = false) Integer studyroomId,
            @ApiParam(required = false) @RequestParam(value = "buildingName", required = false) Integer buildingName,
            @ApiParam(required = false) @RequestParam(value = "studyroomNumber", required = false) Integer studyroomNumber,
            @ApiParam(required = false) @RequestParam(value = "pageNum", defaultValue = "1") @Min(value = 1, message = "页码不能小于1") int pageNum,
            @ApiParam(required = false) @RequestParam(value = "pageSize", defaultValue = "10") @Min(value = 1, message = "每页大小不能小于1") int pageSize,
            @ApiParam(required = false) @RequestParam(value = "sort", required = false, defaultValue = "r_id DESC") String sort
    ) {
        if (ObjectUtils.isEmpty(userId)) {
            return new PageInfo<>();
        }

        ReservationExample reservationExample = new ReservationExample();
        ReservationExample.Criteria criteria = reservationExample.createCriteria();
        Timestamp startOfDay = getStartOfDay();
        criteria.andEndTimeLessThan(startOfDay);
        criteria.andIsCheckinEqualTo(CheckStatusEnum.CLOSE.getStatus());
        criteria.andUserIdEqualTo(userId);

        List<DefaultRecord> defaultRecordList = new ArrayList<>();
        PageInfo<Reservation> reservationList = reservationService.selectByExample(reservationExample, pageNum, pageSize, sort);
        return reservationList;
    }

    private Timestamp convertTime(Timestamp startTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);

        // 将时间设置为当天的开始时间，精确到秒
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        // 格式化后的开始时间
        return new Timestamp(cal.getTimeInMillis());
    }


    private Timestamp getStartOfDay() {
        // 获取当前日期
        LocalDate today = LocalDate.now();

        // 使用上海时区
        ZoneId shanghaiZone = ZoneId.of("Asia/Shanghai");

        // 获取当天的开始时间
        ZonedDateTime startOfDayInShanghai = today.atStartOfDay(shanghaiZone);

        return new Timestamp(startOfDayInShanghai.toInstant().toEpochMilli());
    }


}
