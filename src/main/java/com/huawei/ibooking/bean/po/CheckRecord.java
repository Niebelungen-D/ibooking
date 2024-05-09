package com.huawei.ibooking.bean.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc mbg自动生成check_record表实体类
 * @date 2024-05-09 05:41
 */
public class CheckRecord implements Serializable {
    private Integer checkId;

    private Date checkTime;

    private Integer reservationId;

    private static final long serialVersionUID = 1L;

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", checkId=").append(checkId);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", reservationId=").append(reservationId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}