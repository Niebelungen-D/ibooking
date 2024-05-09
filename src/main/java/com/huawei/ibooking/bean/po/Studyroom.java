package com.huawei.ibooking.bean.po;

import java.io.Serializable;

/**
 * @desc mbg自动生成studyroom表实体类
 * @date 2024-05-09 05:41
 */
public class Studyroom implements Serializable {
    private Integer studyroomId;

    private Boolean roomStatus;

    private Integer studyroomNumber;

    private Integer buildingId;

    private static final long serialVersionUID = 1L;

    public Integer getStudyroomId() {
        return studyroomId;
    }

    public void setStudyroomId(Integer studyroomId) {
        this.studyroomId = studyroomId;
    }

    public Boolean getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Integer getStudyroomNumber() {
        return studyroomNumber;
    }

    public void setStudyroomNumber(Integer studyroomNumber) {
        this.studyroomNumber = studyroomNumber;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studyroomId=").append(studyroomId);
        sb.append(", roomStatus=").append(roomStatus);
        sb.append(", studyroomNumber=").append(studyroomNumber);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}