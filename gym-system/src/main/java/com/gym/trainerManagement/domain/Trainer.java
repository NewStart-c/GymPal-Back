package com.gym.trainerManagement.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gym.common.annotation.Excel;
import com.gym.common.core.domain.BaseEntity;
/**
 * 教练管理对象 trainer
 * 
 * @author cqs
 * @date 2026-04-08
 */
public class Trainer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教练ID */
    private Long trainerId;

    /** 员工ID */
    @Excel(name = "员工ID")
    private Long employeeId;

    /** 专长(JSON格式) */
    @Excel(name = "专长(JSON格式)")
    private String specialties;

    /** 经验描述 */
    @Excel(name = "经验描述")
    private String experience;

    /** 教练图集地址列表 */
    @Excel(name = "教练图集地址列表")
    private String imageUrls;

    public void setTrainerId(Long trainerId) 
    {
        this.trainerId = trainerId;
    }

    public Long getTrainerId() 
    {
        return trainerId;
    }

    public void setEmployeeId(Long employeeId) 
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() 
    {
        return employeeId;
    }

    public void setSpecialties(String specialties) 
    {
        this.specialties = specialties;
    }

    public String getSpecialties() 
    {
        return specialties;
    }

    public void setExperience(String experience) 
    {
        this.experience = experience;
    }

    public String getExperience() 
    {
        return experience;
    }

    public void setImageUrls(String imageUrls) 
    {
        this.imageUrls = imageUrls;
    }

    public String getImageUrls() 
    {
        return imageUrls;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("trainerId", getTrainerId())
            .append("employeeId", getEmployeeId())
            .append("specialties", getSpecialties())
            .append("experience", getExperience())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("imageUrls", getImageUrls())
            .toString();
    }
}
