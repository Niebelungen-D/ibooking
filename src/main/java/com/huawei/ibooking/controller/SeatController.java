//package com.huawei.ibooking.controller;
//
//public class SeatController {
//}
package com.huawei.ibooking.controller;

import com.github.pagehelper.PageInfo;
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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/seat")
@Api(value = "桌位管理", tags = {"管理员端桌位管理"})
public class SeatController {

    @Autowired
    SeatService SeatService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询桌位", tags = "查询桌位")
    public JsonResult<PageInfo<SeatInformation>> getSeatList(
            @ApiParam(required = false) @RequestParam(name = "hasSocket", required = false) Byte hasSocket,
            @ApiParam(required = false) @RequestParam(name = "seatId", required = false) Integer  seatId,
            @ApiParam @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @ApiParam @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @ApiParam @RequestParam(value = "sort", defaultValue = "id DESC") String sort
    ) {
        SeatExample SeatExample = new SeatExample();
        SeatExample.Criteria criteria = SeatExample.createCriteria();
        if (!ObjectUtils.isEmpty(hasSocket)) {
            criteria.andRoomStatusEqualTo(hasSocket);
        }

        if (!ObjectUtils.isEmpty(seatId)) {
            criteria.andStudyroomIdEqualTo(seatId);
        }

        PageInfo<SeatInformation> SeatInformationPageInfo = SeatService.selectByExample(SeatExample, pageNum, pageSize, sort);
        return new JsonResult<>(SeatInformationPageInfo);

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增桌位", tags = "新增桌位")
    public JsonResult<Object>insert(
            @ApiParam(required = true) @RequestParam(name = "hasSocket", required = true) Byte hasSocket,
            @ApiParam(required = true) @RequestParam(name = "seatId", required = true) Integer  seatId,
            @ApiParam(required = true) @RequestParam(name = "buildingId", required = true) Integer buildingId
    ) {
        SeatExample SeatExample = new SeatExample();
        SeatExample.Criteria criteria = SeatExample.createCriteria();
        if (!ObjectUtils.isEmpty(seatId)) {
            criteria.andStudyroomNumberEqualTo(seatId);
        }

        long count = SeatService.countByExample(SeatExample);
        if (count >= 1) {
            return new JsonResult<>(ResponseEnum.STUDY_ROOM_EXIST);
        }
        Seat seat = new Seat();

        // 新创建自习室，都是关闭状态
        seat.setHasSocket(SeatStatusEnum.CLOSE.getStatus());
        seat.setSeatId(seatId);
        int insert = SeatService.insert(seat);
        if (insert >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }

    }


    @RequestMapping(value = "/switch", method = RequestMethod.POST)
    @ApiOperation(value = "切换桌位状态", tags = "切换桌位状态")
    public JsonResult<Object>update(
            @ApiParam(required = true) @RequestParam(name = "seatId", required = true) Integer seatId,
            @ApiParam(required = true) @RequestParam(name = "hasSocket", required = true) Byte hasSocket
    ) {

        SeatExample example = new SeatExample();
        SeatExample.Criteria criteria = example.createCriteria();
        criteria.andStudyroomIdEqualTo(seatId);
        Seat Seat = new Seat();
        Seat.setHasSocket(hasSocket);
        int update = SeatService.updateByExample(Seat, example);
        if (update >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }
    }

}
