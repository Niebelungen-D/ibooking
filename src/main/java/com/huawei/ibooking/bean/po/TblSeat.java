package com.huawei.ibooking.bean.po;

import java.io.Serializable;

/**
 * @desc mbg自动生成tbl_seat表实体类
 * @date 2024-06-05 03:32
 */
public class TblSeat implements Serializable {
    private Integer id;

    private Integer studyroomid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudyroomid() {
        return studyroomid;
    }

    public void setStudyroomid(Integer studyroomid) {
        this.studyroomid = studyroomid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", studyroomid=").append(studyroomid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}