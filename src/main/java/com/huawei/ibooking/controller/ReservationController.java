package com.huawei.ibooking.controller;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.vo.reservation.ReservationInformation;
import com.huawei.ibooking.serivce.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/reservation")
@Api(value = "用户预约", tags = {"用户预约"})
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有预约", tags = "查询预约")
    public PageInfo<ReservationInformation> selectAllReservationsByCondition(
            @ApiParam(required = false) @RequestParam(value = "userName", required = false) String userName,
            @ApiParam(required = false) @RequestParam(value = "buildingName", required = false) String buildingName,
            @ApiParam(required = false) @RequestParam(value = "startTime", required = false) String startTime,
            @ApiParam(required = false) @RequestParam(value = "endTime", required = false) String endTime,
            @ApiParam(required = false) @RequestParam(value = "pageNum", defaultValue = "1") @Min(value = 1, message = "页码不能小于1") int pageNum,
            @ApiParam(required = false) @RequestParam(value = "pageSize", defaultValue = "10") @Min(value = 1, message = "每页大小不能小于1") int pageSize,
            @ApiParam(required = false) @RequestParam(value = "orderByClause", required = false) String orderByClause) {
        // 校验orderByClause参数以防止SQL注入，例如只允许特定的排序字段
        if (orderByClause != null && !isValidOrderByClause(orderByClause)) {
            throw new IllegalArgumentException("排序子句包含非法字符");
        }
        return reservationService.selectAllReservationsByCondition(
                userName,
                buildingName,
                startTime,
                endTime,
                pageNum,
                pageSize,
                orderByClause);
    }

    // 校验orderByClause是否只包含允许的字段
    private boolean isValidOrderByClause(String orderByClause) {
        // 这里可以添加具体的校验逻辑，例如只允许按特定字段排序
        // 例如：只允许排序字段为 "username", "startTime", "endTime"
        return orderByClause.matches("^(username|startTime|endTime)(,\\s*(username|startTime|endTime))*$");
    }

}
