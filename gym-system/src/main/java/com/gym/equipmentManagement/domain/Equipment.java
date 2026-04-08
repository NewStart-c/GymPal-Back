package com.gym.equipmentManagement.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gym.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gym.common.annotation.Excel;

/**
 * 器材对象 equipment
 * 
 * @author cqs
 * @date 2026-04-08
 */
public class Equipment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 器材ID */
    private Long equipmentId;

    /** 器材名称 */
    @Excel(name = "器材名称")
    private String name;

    /** 型号 */
    @Excel(name = "型号")
    private String model;

    /** 购买日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购买日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseDate;

    /** 供应商 */
    @Excel(name = "供应商")
    private String supplier;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 位置 */
    @Excel(name = "位置")
    private String location;

    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }

    public void setPurchaseDate(Date purchaseDate) 
    {
        this.purchaseDate = purchaseDate;
    }

    public Date getPurchaseDate() 
    {
        return purchaseDate;
    }

    public void setSupplier(String supplier) 
    {
        this.supplier = supplier;
    }

    public String getSupplier() 
    {
        return supplier;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("equipmentId", getEquipmentId())
            .append("name", getName())
            .append("model", getModel())
            .append("purchaseDate", getPurchaseDate())
            .append("supplier", getSupplier())
            .append("price", getPrice())
            .append("status", getStatus())
            .append("location", getLocation())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
