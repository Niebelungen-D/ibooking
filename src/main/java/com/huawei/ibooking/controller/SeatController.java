package com.huawei.ibooking.controller;

import com.huawei.ibooking.bean.Do.seat.QuerySeatResult;
import com.huawei.ibooking.bean.dto.seat.InsertSeatRequest;
import com.huawei.ibooking.bean.dto.seat.SwitchSeatRequest;
import com.huawei.ibooking.bean.enums.ResponseEnum;
import com.huawei.ibooking.bean.enums.SeatStatusEnum;
import com.huawei.ibooking.bean.po.Seat;
import com.huawei.ibooking.bean.po.SeatExample;
import com.huawei.ibooking.bean.po.Studyroom;
import com.huawei.ibooking.commons.JsonResult;
import com.huawei.ibooking.serivce.SeatService;
import com.huawei.ibooking.serivce.StudyroomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/seat")
@Api(value = "桌位管理", tags = {"管理员端桌位管理"})
public class SeatController {

    @Autowired(required = false)
    SeatService seatService;

    @Autowired(required = false)
    StudyroomService studyroomService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询桌位", tags = "查询桌位")
    public JsonResult<List<QuerySeatResult>> getSeatList(
//            @ApiParam(required = false) @RequestParam(name = "hasSocket", required = false) Byte hasSocket,
//            @ApiParam(required = false) @RequestParam(name = "seatId", required = false) Integer  seatId,
            @ApiParam(required = true) @RequestParam(name = "studyroomId", required = true) Integer studyroomId,
            @ApiParam(required = true) @RequestParam(name = "startTime", required = true) Long startTime
//            @ApiParam(required = false) @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
//            @ApiParam(required = false) @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
//            @ApiParam(required = false) @RequestParam(name = "sort", defaultValue = "seat_id DESC") String sort
    ) {
        System.out.println(startTime);
        Timestamp formatStartTime = new Timestamp(startTime);
        List<QuerySeatResult> seatResultList = seatService.getSeatBookingStatus(studyroomId, formatStartTime);
        return new JsonResult<>(seatResultList);

    }

//    public JsonResult<List<QuerySeatResult>> getSeatBookingStatus(
//
//    ) {
//
//    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增桌位", tags = "新增桌位")
    public JsonResult<Object>insert(
            @ApiParam(required = true) @RequestBody InsertSeatRequest insertSeatRequest
    ) {
        Integer studyroomId = insertSeatRequest.getStudyroomId();
        Integer seatNumber = insertSeatRequest.getSeatNumber();
        if (ObjectUtils.isEmpty(studyroomId) || ObjectUtils.isEmpty(seatNumber)) {
            return new JsonResult<>(ResponseEnum.BAD_REQUEST);
        }
        if (!isValidSeatNumber(seatNumber)) {
            return new JsonResult<>("3000", "请求参数不合法，座位号为1-1000的整数");
        }

        Studyroom studyroom = studyroomService.selectByPrimaryKey(studyroomId);
        if (ObjectUtils.isEmpty(studyroom)) {
            return new JsonResult<>("3000", "自习室ID不存在，请检查输入参数！");
        }

        SeatExample example = new SeatExample();
        SeatExample.Criteria criteria = example.createCriteria();
        criteria.andStudyroomIdEqualTo(studyroomId);
        criteria.andSeatNumberEqualTo(seatNumber);

        long l = seatService.countByExample(example);
        if (l >= 1L) {
            return new JsonResult<>("3000", "座位号已经被占用，请换一个座位号");
        }



        Seat seat = new Seat();
        seat.setHasSocket(SeatStatusEnum.CLOSE.getStatus());
        seat.setStudyroomId(studyroomId);
        seat.setSeatNumber(seatNumber);
        int insert = seatService.insert(seat);
        if (insert >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }

    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改桌位信息", tags = "修改桌位信息")
    public JsonResult<Object>update(
            @ApiParam(required = true) @RequestBody SwitchSeatRequest switchSeatRequest
            ) {
        Integer seatId = switchSeatRequest.getSeatId();
        Byte hasSocket = switchSeatRequest.getHasSocket();
        Integer seatNumber = switchSeatRequest.getSeatNumber();
        Integer studyroomId = switchSeatRequest.getStudyroomId();
        if (ObjectUtils.isEmpty(seatId) || ObjectUtils.isEmpty(hasSocket) || ObjectUtils.isEmpty(seatNumber) || ObjectUtils.isEmpty(studyroomId)) {
            return new JsonResult<>(ResponseEnum.BAD_REQUEST);
        }
        if (!isValidSeatNumber(seatNumber)) {
            return new JsonResult<>("3000", "请求参数不合法，座位号为1-1000的整数");
        }
        SeatExample example = new SeatExample();
        SeatExample.Criteria criteria = example.createCriteria();
        criteria.andSeatNumberEqualTo(seatNumber);
        criteria.andStudyroomIdEqualTo(studyroomId);

        Studyroom studyroom = studyroomService.selectByPrimaryKey(studyroomId);
        if (ObjectUtils.isEmpty(studyroom)) {
            return new JsonResult<>("3000", "自习室ID不存在，请检查输入参数！");
        }


        long l = seatService.countByExample(example);
        if (l >= 1) {
            return new JsonResult<>("3000", "座位号已经被占用，请换一个座位号");
        }

        // 校验通过，更新信息
        SeatExample example2 = new SeatExample();
        SeatExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andStudyroomIdEqualTo(studyroomId);
        criteria2.andSeatIdEqualTo(seatId);
        Seat seat = new Seat();
        seat.setHasSocket(hasSocket);
        seat.setSeatNumber(seatNumber);
        int update = seatService.updateByExampleSelective(seat, example2);
        if (update >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }
    }

    private boolean isValidSeatNumber(Integer seatNumber) {
        // 检查seatNumber是否为空
        if (ObjectUtils.isEmpty(seatNumber)) {
            return false;
        }
        // 检查seatNumber是否在1到1000的范围内
        return seatNumber >= 1 && seatNumber <= 1000;
    }


}
