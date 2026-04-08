package com.gym.equipmentManagement.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gym.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gym.common.annotation.Excel;

/**
 * 器材维护对象 equipment_maintenance
 * 
 * @author cqs
 * @date 2026-04-08
 */
public class EquipmentMaintenance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 维护ID */
    private Long maintenanceId;

    /** 器材ID */
    @Excel(name = "器材ID")
    private Long equipmentId;

    /** 维护日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "维护日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date maintenanceDate;

    /** 维护内容 */
    @Excel(name = "维护内容")
    private String maintenanceContent;

    /** 维护人ID */
    @Excel(name = "维护人ID")
    private Long maintainerId;

    /** 下次维护日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下次维护日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date nextMaintenanceDate;

    public void setMaintenanceId(Long maintenanceId) 
    {
        this.maintenanceId = maintenanceId;
    }

    public Long getMaintenanceId() 
    {
        return maintenanceId;
    }

    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }

    public void setMaintenanceDate(Date maintenanceDate) 
    {
        this.maintenanceDate = maintenanceDate;
    }

    public Date getMaintenanceDate() 
    {
        return maintenanceDate;
    }

    public void setMaintenanceContent(String maintenanceContent) 
    {
        this.maintenanceContent = maintenanceContent;
    }

    public String getMaintenanceContent() 
    {
        return maintenanceContent;
    }

    public void setMaintainerId(Long maintainerId) 
    {
        this.maintainerId = maintainerId;
    }

    public Long getMaintainerId() 
    {
        return maintainerId;
    }

    public void setNextMaintenanceDate(Date nextMaintenanceDate) 
    {
        this.nextMaintenanceDate = nextMaintenanceDate;
    }

    public Date getNextMaintenanceDate() 
    {
        return nextMaintenanceDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("maintenanceId", getMaintenanceId())
            .append("equipmentId", getEquipmentId())
            .append("maintenanceDate", getMaintenanceDate())
            .append("maintenanceContent", getMaintenanceContent())
            .append("maintainerId", getMaintainerId())
            .append("nextMaintenanceDate", getNextMaintenanceDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
