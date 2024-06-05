package com.huawei.ibooking.bean.po;

import java.io.Serializable;

/**
 * @desc mbg自动生成tbl_study_room表实体类
 * @date 2024-06-05 03:32
 */
public class TblStudyRoom implements Serializable {
    private Integer id;

    private String buildingnum;

    private String classroomnum;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildingnum() {
        return buildingnum;
    }

    public void setBuildingnum(String buildingnum) {
        this.buildingnum = buildingnum;
    }

    public String getClassroomnum() {
        return classroomnum;
    }

    public void setClassroomnum(String classroomnum) {
        this.classroomnum = classroomnum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", buildingnum=").append(buildingnum);
        sb.append(", classroomnum=").append(classroomnum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}