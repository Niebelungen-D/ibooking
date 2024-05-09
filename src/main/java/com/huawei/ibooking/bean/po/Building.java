package com.huawei.ibooking.bean.po;

import java.io.Serializable;

/**
 * @desc mbg自动生成building表实体类
 * @date 2024-05-09 05:41
 */
public class Building implements Serializable {
    private Integer buildingId;

    /**
     * 教学楼的名称
     *
     * @mbg.generated
     */
    private String buildingName;

    private static final long serialVersionUID = 1L;

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", buildingId=").append(buildingId);
        sb.append(", buildingName=").append(buildingName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}