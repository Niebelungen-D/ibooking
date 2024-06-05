package com.huawei.ibooking.bean.po;

import java.io.Serializable;

/**
 * @desc mbg自动生成seat表实体类
 * @date 2024-06-05 03:32
 */
public class Seat implements Serializable {
    private Integer seatId;

    private Byte hasSocket;

    private Integer studyroomId;

    /**
     * 座位的编号
     *
     * @mbg.generated
     */
    private Integer seatNumber;

    private static final long serialVersionUID = 1L;

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Byte getHasSocket() {
        return hasSocket;
    }

    public void setHasSocket(Byte hasSocket) {
        this.hasSocket = hasSocket;
    }

    public Integer getStudyroomId() {
        return studyroomId;
    }

    public void setStudyroomId(Integer studyroomId) {
        this.studyroomId = studyroomId;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", seatId=").append(seatId);
        sb.append(", hasSocket=").append(hasSocket);
        sb.append(", studyroomId=").append(studyroomId);
        sb.append(", seatNumber=").append(seatNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}