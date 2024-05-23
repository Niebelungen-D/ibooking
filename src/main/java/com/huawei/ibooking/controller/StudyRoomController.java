package com.huawei.ibooking.controller;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.po.StudyroomExample;
import com.huawei.ibooking.bean.vo.studyroom.StudyRoomInformation;
import com.huawei.ibooking.commons.JsonResult;
import com.huawei.ibooking.serivce.StudyroomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/studyroom")
@Api(value = "自习室管理", tags = {"管理员端自习室管理"})
public class StudyRoomController {

    @Autowired
    StudyroomService studyroomService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询自习室", tags = "查询自习室")
    public JsonResult<PageInfo<StudyRoomInformation>> getStudyRoomList(
            @ApiParam(required = false) @RequestParam(name = "room_status", required = false) Boolean roomStatus,
            @ApiParam(required = false) @RequestParam(name = "studyroom_number", required = false) Integer  studyroomNumer,
            @ApiParam(required = false) @RequestParam(name = "building_id", required = false) Integer buildingId,
            @ApiParam @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @ApiParam @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @ApiParam @RequestParam(value = "sort", defaultValue = "id DESC") String sort
    ) {
        StudyroomExample studyroomExample = new StudyroomExample();
        StudyroomExample.Criteria criteria = studyroomExample.createCriteria();
        if (!ObjectUtils.isEmpty(roomStatus)) {
            criteria.andRoomStatusEqualTo(roomStatus);
        }

        if (!ObjectUtils.isEmpty(studyroomNumer)) {
            criteria.andStudyroomIdEqualTo(studyroomNumer);
        }

        if (!ObjectUtils.isEmpty(buildingId)) {
            criteria.andBuildingIdEqualTo(buildingId);
        }

        PageInfo<StudyRoomInformation> studyRoomInformationPageInfo = studyroomService.selectByExample(studyroomExample, pageNum, pageSize, sort);
        return new JsonResult<>(studyRoomInformationPageInfo);

    }



}
