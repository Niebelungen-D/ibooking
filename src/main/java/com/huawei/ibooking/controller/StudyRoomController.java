package com.huawei.ibooking.controller;

import com.github.pagehelper.PageInfo;
import com.huawei.ibooking.bean.dto.studyroom.InsertStudyroomRequest;
import com.huawei.ibooking.bean.dto.studyroom.SwitchStudyroomRequest;
import com.huawei.ibooking.bean.enums.ResponseEnum;
import com.huawei.ibooking.bean.enums.StudyRoomStatusEnum;
import com.huawei.ibooking.bean.po.Studyroom;
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
            @ApiParam(required = false) @RequestParam(name = "roomStatus", required = false) Boolean roomStatus,
            @ApiParam(required = false) @RequestParam(name = "studyroomNumber", required = false) Integer  studyroomNumer,
            @ApiParam(required = false) @RequestParam(name = "buildingId", required = false) Integer buildingId,
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

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value = "新增自习室", tags = "新增自习室")
    public JsonResult<Object>insert(
            @ApiParam(required = true) @RequestBody InsertStudyroomRequest insertStudyroomRequest
    ) {
        Integer studyroomNumber = insertStudyroomRequest.getStudyroomNumber();
        Integer buildingId = insertStudyroomRequest.getBuildingId();
        StudyroomExample studyroomExample = new StudyroomExample();
        StudyroomExample.Criteria criteria = studyroomExample.createCriteria();
        if (!ObjectUtils.isEmpty(studyroomNumber)) {
            criteria.andStudyroomNumberEqualTo(studyroomNumber);
        }

        if (!ObjectUtils.isEmpty(buildingId)) {
            criteria.andBuildingIdEqualTo(buildingId);
        }
        long count = studyroomService.countByExample(studyroomExample);
        if (count >= 1) {
            return new JsonResult<>(ResponseEnum.STUDY_ROOM_EXIST);
        }
        Studyroom studyroom = new Studyroom();
        studyroom.setBuildingId(buildingId);
        // 新创建自习室，都是关闭状态
        studyroom.setRoomStatus(StudyRoomStatusEnum.CLOSE.getStatus());
        studyroom.setStudyroomNumber(studyroomNumber);
        int insert = studyroomService.insert(studyroom);
        if (insert >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }

    }


    @RequestMapping(value = "/switch", method = RequestMethod.POST)
    @ApiOperation(value = "切换自习室状态", tags = "切换自习室状态")
    public JsonResult<Object>update(
//            @ApiParam(required = true) @RequestParam(name = "studyroomId", required = true) Integer studyroomId,
//            @ApiParam(required = true) @RequestParam(name = "roomStatus", required = true) Boolean roomStatus
            @ApiParam(required = true) @RequestBody SwitchStudyroomRequest switchStudyroomRequest
    ) {
        Integer studyroomId = switchStudyroomRequest.getStudyroomId();
        Boolean roomStatus = switchStudyroomRequest.getRoomStatus();


        StudyroomExample example = new StudyroomExample();
        StudyroomExample.Criteria criteria = example.createCriteria();
        criteria.andStudyroomIdEqualTo(studyroomId);
        Studyroom studyroom = new Studyroom();
        studyroom.setRoomStatus(roomStatus);
        studyroom.setStudyroomId(studyroomId);
        int update = studyroomService.updateByExample(studyroom, example);
        if (update >= 1) {
            return new JsonResult<>(ResponseEnum.OPERATE_SUCCESS);
        } else {
            return new JsonResult<>(ResponseEnum.OPERATE_FAILURE);
        }
    }

}
