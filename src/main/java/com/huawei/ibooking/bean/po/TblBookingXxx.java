package com.huawei.ibooking.bean.po;

import java.io.Serializable;

/**
 * @desc mbg自动生成tbl_booking_xxx表实体类
 * @date 2024-06-05 03:32
 */
public class TblBookingXxx implements Serializable {
    private Integer id;

    private Integer seatid;

    private Integer bookingperiod;

    private Integer stuid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeatid() {
        return seatid;
    }

    public void setSeatid(Integer seatid) {
        this.seatid = seatid;
    }

    public Integer getBookingperiod() {
        return bookingperiod;
    }

    public void setBookingperiod(Integer bookingperiod) {
        this.bookingperiod = bookingperiod;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", seatid=").append(seatid);
        sb.append(", bookingperiod=").append(bookingperiod);
        sb.append(", stuid=").append(stuid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}