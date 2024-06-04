package com.huawei.ibooking.controller;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.Do.seat.QuerySeatResult;
import com.huawei.ibooking.bean.dto.seat.InsertSeatRequest;
import com.huawei.ibooking.bean.dto.seat.SwitchSeatRequest;
import com.huawei.ibooking.bean.enums.ResponseEnum;
import com.huawei.ibooking.bean.enums.SeatStatusEnum;
import com.huawei.ibooking.bean.po.Seat;
import com.huawei.ibooking.bean.po.SeatExample;
import com.huawei.ibooking.bean.vo.Seat.SeatInformation;
import com.huawei.ibooking.commons.JsonResult;
import com.huawei.ibooking.serivce.SeatService;
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
    SeatService SeatService;

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
        List<QuerySeatResult> seatResultList = SeatService.getSeatBookingStatus(studyroomId, formatStartTime);
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
        System.out.println(studyroomId);
        Seat seat = new Seat();
        seat.setHasSocket(SeatStatusEnum.CLOSE.getStatus());
        seat.setStudyroomId(studyroomId);
        int insert = SeatService.insert(seat);
        if (insert >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }

    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "切换桌位状态", tags = "切换桌位状态")
    public JsonResult<Object>update(
            @ApiParam(required = true) @RequestBody SwitchSeatRequest switchSeatRequest
            ) {
        Integer seatId = switchSeatRequest.getSeatId();
        Byte hasSocket = switchSeatRequest.getHasSocket();
        SeatExample example = new SeatExample();
        SeatExample.Criteria criteria = example.createCriteria();
        criteria.andSeatIdEqualTo(seatId);
        Seat seat = new Seat();
        seat.setHasSocket(hasSocket);
        int update = SeatService.updateByExampleSelective(seat, example);
        if (update >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }
    }

}
