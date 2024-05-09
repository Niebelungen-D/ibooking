package com.huawei.ibooking.bean.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc mbg自动生成reservation表实体类
 * @date 2024-05-09 05:41
 */
public class Reservation implements Serializable {
    private Integer rId;

    private Integer seatId;

    private Integer userId;

    private Date startTime;

    private Date endTime;

    private Boolean isCheckin;

    private Integer buildingId;

    private Integer studyroomId;

    private static final long serialVersionUID = 1L;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getIsCheckin() {
        return isCheckin;
    }

    public void setIsCheckin(Boolean isCheckin) {
        this.isCheckin = isCheckin;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getStudyroomId() {
        return studyroomId;
    }

    public void setStudyroomId(Integer studyroomId) {
        this.studyroomId = studyroomId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rId=").append(rId);
        sb.append(", seatId=").append(seatId);
        sb.append(", userId=").append(userId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", isCheckin=").append(isCheckin);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", studyroomId=").append(studyroomId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}