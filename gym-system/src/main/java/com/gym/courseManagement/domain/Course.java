package com.gym.courseManagement.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gym.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gym.common.annotation.Excel;

/**
 * 课程信息对象 course
 * 
 * @author cqs
 * @date 2026-04-08
 */
public class Course extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程ID */
    private Long courseId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** (课程类型关联dict_type) */
    @Excel(name = "(课程类型关联dict_type)")
    private String courseType;

    /** 教练ID */
    @Excel(name = "教练ID")
    private Long trainerId;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 地点 */
    @Excel(name = "地点")
    private String location;

    /** 最大容量 */
    @Excel(name = "最大容量")
    private Long maxCapacity;

    /** 当前报名人数 */
    @Excel(name = "当前报名人数")
    private Long currentEnrollment;

    /** 状态(0待开始 1进行中 2已结束) */
    @Excel(name = "状态(0待开始 1进行中 2已结束)")
    private String status;

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }

    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }

    public void setCourseType(String courseType) 
    {
        this.courseType = courseType;
    }

    public String getCourseType() 
    {
        return courseType;
    }

    public void setTrainerId(Long trainerId) 
    {
        this.trainerId = trainerId;
    }

    public Long getTrainerId() 
    {
        return trainerId;
    }

    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }

    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }

    public void setMaxCapacity(Long maxCapacity) 
    {
        this.maxCapacity = maxCapacity;
    }

    public Long getMaxCapacity() 
    {
        return maxCapacity;
    }

    public void setCurrentEnrollment(Long currentEnrollment) 
    {
        this.currentEnrollment = currentEnrollment;
    }

    public Long getCurrentEnrollment() 
    {
        return currentEnrollment;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseId", getCourseId())
            .append("courseName", getCourseName())
            .append("courseType", getCourseType())
            .append("trainerId", getTrainerId())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("location", getLocation())
            .append("maxCapacity", getMaxCapacity())
            .append("currentEnrollment", getCurrentEnrollment())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
