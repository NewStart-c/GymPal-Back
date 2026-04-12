package com.gym.empManagement.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gym.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gym.common.annotation.Excel;

/**
 * 员工排班对象 emp_schedule
 * 
 * @author cqs
 * @date 2026-04-12
 */
public class EmpSchedule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 排班ID */
    private Long scheduleId;

    /** 员工ID（关联sys_user.user_id） */
    @Excel(name = "员工ID", readConverterExp = "关=联sys_user.user_id")
    private Long userId;

    /** 排班日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "排班日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date scheduleDate;

    /** 上班时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "上班时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 下班时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "下班时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 排班类型（0前台 1私教 2保洁 3其他） */
    @Excel(name = "排班类型", readConverterExp = "0=前台,1=私教,2=保洁,3=其他")
    private String scheduleType;

    /** 工作内容（如前台接待、私教课程、场地清洁） */
    @Excel(name = "工作内容", readConverterExp = "如=前台接待、私教课程、场地清洁")
    private String workContent;

    /** 排班状态（0正常 1停用/已取消） */
    @Excel(name = "排班状态", readConverterExp = "0=正常,1=停用/已取消")
    private String status;

    /** 删除标志（0存在 2删除） */
    private String delFlag;

    public void setScheduleId(Long scheduleId) 
    {
        this.scheduleId = scheduleId;
    }

    public Long getScheduleId() 
    {
        return scheduleId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setScheduleDate(Date scheduleDate) 
    {
        this.scheduleDate = scheduleDate;
    }

    public Date getScheduleDate() 
    {
        return scheduleDate;
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

    public void setScheduleType(String scheduleType) 
    {
        this.scheduleType = scheduleType;
    }

    public String getScheduleType() 
    {
        return scheduleType;
    }

    public void setWorkContent(String workContent) 
    {
        this.workContent = workContent;
    }

    public String getWorkContent() 
    {
        return workContent;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scheduleId", getScheduleId())
            .append("userId", getUserId())
            .append("scheduleDate", getScheduleDate())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("scheduleType", getScheduleType())
            .append("workContent", getWorkContent())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
