package com.gym.memberManagement.domain;

import java.math.BigDecimal;

import com.gym.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gym.common.annotation.Excel;

/**
 * 会员等级对象 member_level
 * 
 * @author cqs
 * @date 2026-04-08
 */
public class MemberLevel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 等级ID */
    private Long levelId;

    /** 等级名称 */
    @Excel(name = "等级名称")
    private String levelName;

    /** 等级描述 */
    @Excel(name = "等级描述")
    private String description;

    /** 折扣率 */
    @Excel(name = "折扣率")
    private BigDecimal discountRate;

    /** 权益列表(JSON格式) */
    @Excel(name = "权益列表(JSON格式)")
    private String benefits;

    public void setLevelId(Long levelId) 
    {
        this.levelId = levelId;
    }

    public Long getLevelId() 
    {
        return levelId;
    }

    public void setLevelName(String levelName) 
    {
        this.levelName = levelName;
    }

    public String getLevelName() 
    {
        return levelName;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDiscountRate(BigDecimal discountRate) 
    {
        this.discountRate = discountRate;
    }

    public BigDecimal getDiscountRate() 
    {
        return discountRate;
    }

    public void setBenefits(String benefits) 
    {
        this.benefits = benefits;
    }

    public String getBenefits() 
    {
        return benefits;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("levelId", getLevelId())
            .append("levelName", getLevelName())
            .append("description", getDescription())
            .append("discountRate", getDiscountRate())
            .append("benefits", getBenefits())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
