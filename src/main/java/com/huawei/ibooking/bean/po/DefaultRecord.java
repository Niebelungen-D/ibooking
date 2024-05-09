package com.huawei.ibooking.bean.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc mbg自动生成default_record表实体类
 * @date 2024-05-09 05:41
 */
public class DefaultRecord implements Serializable {
    private Integer dId;

    private Integer userId;

    private Integer rId;

    private Integer seatId;

    private Date startTime;

    private Date endTime;

    private Integer buildingId;

    private Integer studyroomId;

    private String buildingName;

    private Integer studyroomNumber;

    private static final long serialVersionUID = 1L;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getStudyroomNumber() {
        return studyroomNumber;
    }

    public void setStudyroomNumber(Integer studyroomNumber) {
        this.studyroomNumber = studyroomNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dId=").append(dId);
        sb.append(", userId=").append(userId);
        sb.append(", rId=").append(rId);
        sb.append(", seatId=").append(seatId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", studyroomId=").append(studyroomId);
        sb.append(", buildingName=").append(buildingName);
        sb.append(", studyroomNumber=").append(studyroomNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}