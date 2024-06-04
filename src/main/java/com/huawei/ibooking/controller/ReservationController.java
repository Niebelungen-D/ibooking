package com.huawei.ibooking.controller;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.dto.reservation.InsertReservationRequest;
import com.huawei.ibooking.bean.dto.reservation.UpdateReservationRequest;
import com.huawei.ibooking.bean.enums.CheckStatusEnum;
import com.huawei.ibooking.bean.enums.ResponseEnum;
import com.huawei.ibooking.bean.po.Reservation;
import com.huawei.ibooking.bean.po.ReservationExample;
import com.huawei.ibooking.bean.po.SeatExample;
import com.huawei.ibooking.bean.vo.reservation.ReservationInformation;
import com.huawei.ibooking.commons.JsonResult;
import com.huawei.ibooking.serivce.ReservationService;
import com.huawei.ibooking.serivce.SeatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/reservation")
@Api(value = "用户预约", tags = {"用户预约"})
public class ReservationController {

    @Autowired
    ReservationService reservationService;


    @Autowired
    SeatService seatService;

//    @RequestMapping(value = "/query", method = RequestMethod.GET)
//    @ApiOperation(value = "查询所有预约", tags = "查询预约")
//    public PageInfo<ReservationInformation> selectAllReservationsByCondition(
//            @ApiParam(required = false) @RequestParam(value = "userName", required = false) String userName,
//            @ApiParam(required = false) @RequestParam(value = "buildingName", required = false) String buildingName,
//            @ApiParam(required = false) @RequestParam(value = "startTime", required = false) String startTime,
//            @ApiParam(required = false) @RequestParam(value = "endTime", required = false) String endTime,
//            @ApiParam(required = false) @RequestParam(value = "pageNum", defaultValue = "1") @Min(value = 1, message = "页码不能小于1") int pageNum,
//            @ApiParam(required = false) @RequestParam(value = "pageSize", defaultValue = "10") @Min(value = 1, message = "每页大小不能小于1") int pageSize,
//            @ApiParam(required = false) @RequestParam(value = "orderByClause", required = false) String orderByClause) {
//        // 校验orderByClause参数以防止SQL注入，例如只允许特定的排序字段
//        if (orderByClause != null && !isValidOrderByClause(orderByClause)) {
//            throw new IllegalArgumentException("排序子句包含非法字符");
//        }
//        return reservationService.selectAllReservationsByCondition(
//                userName,
//                buildingName,
//                startTime,
//                endTime,
//                pageNum,
//                pageSize,
//                orderByClause);
//    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "管理员查询所有预约", tags = "管理员查询预约")
    public PageInfo<Reservation> selectAllReservationsByCondition(
            @ApiParam(required = false) @RequestParam(value = "userId", required = false) Integer userId,
            @ApiParam(required = false) @RequestParam(value = "seatId", required = false) Integer seatId,
            @ApiParam(required = false) @RequestParam(value = "isCheckin", required = false) Boolean isCheckin,
            @ApiParam(required = false) @RequestParam(value = "buildingId", required = false) Integer buildingId,
            @ApiParam(required = false) @RequestParam(value = "studyroomId", required = false, defaultValue = "") Integer studyroomId,
            @ApiParam(required = false) @RequestParam(value = "pageNum", defaultValue = "1") @Min(value = 1, message = "页码不能小于1") int pageNum,
            @ApiParam(required = false) @RequestParam(value = "pageSize", defaultValue = "10") @Min(value = 1, message = "每页大小不能小于1") int pageSize,
            @ApiParam(required = false) @RequestParam(value = "sort", required = false, defaultValue = "r_id DESC") String sort) {
        // 校验orderByClause参数以防止SQL注入，例如只允许特定的排序字段
//        if (sort != null && !isValidOrderByClause(sort)) {
//            return new PageInfo<>();
//        }
        ReservationExample reservationExample = new ReservationExample();
        ReservationExample.Criteria criteria = reservationExample.createCriteria();
        if (!ObjectUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!ObjectUtils.isEmpty(seatId)) {
            criteria.andSeatIdEqualTo(seatId);
        }
        if (!ObjectUtils.isEmpty(isCheckin)) {
            criteria.andIsCheckinEqualTo(isCheckin);
        }
        if (!ObjectUtils.isEmpty(buildingId)) {
            criteria.andBuildingIdEqualTo(buildingId);
        }
        if (!ObjectUtils.isEmpty(studyroomId)) {
            criteria.andStudyroomIdEqualTo(studyroomId);
        }

        return reservationService.selectByExample(reservationExample, pageNum, pageSize, sort);

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增预约", tags = "新增预约")
    public JsonResult<Object> addReservation(
            @ApiParam(required = true) @RequestBody InsertReservationRequest insertReservationRequest
            ) {
        Timestamp startTime = insertReservationRequest.getStartTime();
        Timestamp endTime = insertReservationRequest.getEndTime();
        Integer userId = insertReservationRequest.getUserId();
        Integer seatId = insertReservationRequest.getSeatId();
        Integer buildingId = insertReservationRequest.getBuildingId();
        Integer studyroomId = insertReservationRequest.getStudyroomId();
        if (ObjectUtils.isEmpty(startTime) || ObjectUtils.isEmpty(endTime) || ObjectUtils.isEmpty(userId) || ObjectUtils.isEmpty(seatId) || ObjectUtils.isEmpty(buildingId) || ObjectUtils.isEmpty(studyroomId)) {
            return new JsonResult<>(ResponseEnum.BAD_REQUEST);
        }

        if (startTime.getTime() < getStartTimeOfDay()) {
            return new JsonResult<>(String.valueOf(3000), "只能预约今天及之后的自习室");
        }

//        if (endTime.before(startTime)) {
//            return new JsonResult<>(String.valueOf(3000), "结束时间必须大于开始时间");
//        }

        //check if seat exits
        SeatExample seatExample = new SeatExample();
        SeatExample.Criteria criteria = seatExample.createCriteria();
        criteria.andStudyroomIdEqualTo(studyroomId);
        criteria.andSeatIdEqualTo(seatId);
        long count = seatService.countByExample(seatExample);
        if (count <= 0) {
            return new JsonResult<>(ResponseEnum.SEAT_NOT_EXIST);
        }

        // check if time conflicts
//        if(!reservationService.isReservationAvailable(seatId, startTime, endTime)) {
//            return new JsonResult<>(ResponseEnum.SEAT_RESERVATION_CONFLICT);
//        }


        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);

        // 将时间设置为当天的开始时间，精确到秒
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        // 格式化后的开始时间
        Timestamp formattedStartTime = new Timestamp(cal.getTimeInMillis());

        ReservationExample reservationExample = new ReservationExample();
        ReservationExample.Criteria criteria1 = reservationExample.createCriteria();
        criteria1.andStartTimeEqualTo(formattedStartTime);
        criteria1.andStudyroomIdEqualTo(studyroomId);
        criteria1.andBuildingIdEqualTo(buildingId);
        criteria1.andSeatIdEqualTo(seatId);

        long count1 = reservationService.countByExample(reservationExample);
        if (count1 >= 1) {
            return new JsonResult<>(ResponseEnum.SEAT_RESERVATION_CONFLICT);
        }

        Reservation reservation = new Reservation();
        reservation.setIsCheckin(CheckStatusEnum.CLOSE.getStatus());
        reservation.setStartTime(formattedStartTime);
        reservation.setSeatId(seatId);
        reservation.setStudyroomId(studyroomId);
        reservation.setBuildingId(buildingId);
        reservation.setUserId(userId);

        cal.add(Calendar.DAY_OF_MONTH, 1);
        reservation.setEndTime(new Timestamp(cal.getTimeInMillis()));
        if (reservationService.insert(reservation) >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }


    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改预约", tags = "修改预约")
    public JsonResult<Object> updateReservation(
            @ApiParam(required = true) @RequestBody UpdateReservationRequest updateReservationRequest
    ) {
        Integer rId = updateReservationRequest.getRId();
        Timestamp startTime = updateReservationRequest.getStartTime();
        Timestamp endTime = updateReservationRequest.getEndTime();
        Integer userId = updateReservationRequest.getUserId();
        Integer seatId = updateReservationRequest.getSeatId();
        Integer buildingId = updateReservationRequest.getBuildingId();
        Integer studyroomId = updateReservationRequest.getStudyroomId();

        if (ObjectUtils.isEmpty(rId) || ObjectUtils.isEmpty(startTime) || ObjectUtils.isEmpty(endTime) || ObjectUtils.isEmpty(userId) || ObjectUtils.isEmpty(seatId) || ObjectUtils.isEmpty(buildingId) || ObjectUtils.isEmpty(studyroomId)) {
            return new JsonResult<>(ResponseEnum.BAD_REQUEST);
        }

        if (startTime.getTime() < getStartTimeOfDay()) {
            return new JsonResult<>(String.valueOf(3000), "只能预约今天及之后的自习室");
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        // 将时间设置为当天的开始时间，精确到秒
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        // 格式化后的开始时间
        Timestamp formattedStartTime = new Timestamp(cal.getTimeInMillis());

        ReservationExample reservationExample = new ReservationExample();
        ReservationExample.Criteria criteria = reservationExample.createCriteria();

        criteria.andStartTimeEqualTo(formattedStartTime);
        criteria.andStudyroomIdEqualTo(studyroomId);
        criteria.andBuildingIdEqualTo(buildingId);
        criteria.andSeatIdEqualTo(seatId);

        long count = reservationService.countByExample(reservationExample);
        if (count >= 1) {
            return new JsonResult<>(ResponseEnum.SEAT_RESERVATION_CONFLICT);
        }

        Reservation reservation = new Reservation();
        reservation.setIsCheckin(CheckStatusEnum.CLOSE.getStatus());
        reservation.setStartTime(formattedStartTime);
        reservation.setSeatId(seatId);
        reservation.setStudyroomId(studyroomId);
        reservation.setBuildingId(buildingId);
        reservation.setUserId(userId);

        ReservationExample reservationExample1 = new ReservationExample();
        ReservationExample.Criteria criteria1 = reservationExample1.createCriteria();
        criteria1.andRIdEqualTo(rId);
        criteria1.andUserIdEqualTo(userId);

        int update = reservationService.updateByExample(reservation, reservationExample1);
        if (update >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }

    }



    // 校验orderByClause是否只包含允许的字段
    private boolean isValidOrderByClause(String orderByClause) {
        // 这里可以添加具体的校验逻辑，例如只允许按特定字段排序
        return orderByClause.matches("^(studyroomId|buildingId|isCheckin|seatId|userId|startTime|endTime)(,\\s*(studyroomId|buildingId|isCheckin|seatId|userId|startTime|endTime))*$");
    }

    private boolean isValidMillisTimestamp(Timestamp timestamp) {
        // 检查timestamp是否为null
        if (timestamp == null) {
            return false;
        }

        // 获取时间戳的毫秒值
        long millis = timestamp.getTime();

        // 检查时间戳的毫秒值是否不为负
        return millis >= 0;
    }

    private Long getStartTimeOfDay() {
        LocalDate today = LocalDate.now();

        // 使用上海时区
        ZoneId shanghaiZone = ZoneId.of("Asia/Shanghai");
        ZonedDateTime startOfDayInShanghai = today.atStartOfDay(shanghaiZone);

        // 转换为Instant并获取时间戳
        Instant startOfDayInstant = startOfDayInShanghai.toInstant();
        return startOfDayInstant.toEpochMilli();
    }

}
