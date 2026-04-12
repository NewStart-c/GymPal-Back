package com.gym.courseManagement.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gym.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gym.common.annotation.Excel;

/**
 * 课程订单对象 course_order
 * 
 * @author cqs
 * @date 2026-04-12
 */
public class CourseOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程订单ID */
    private Long orderId;

    /** 会员ID */
    @Excel(name = "会员ID")
    private Long memberId;

    /** 课程ID */
    @Excel(name = "课程ID")
    private Long courseId;

    /** 订单金额 */
    @Excel(name = "订单金额")
    private BigDecimal amount;

    /** 支付方式 */
    @Excel(name = "支付方式")
    private String paymentMethod;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 操作员ID */
    @Excel(name = "操作员ID")
    private Long operatorId;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }

    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }

    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }

    public void setPaymentMethod(String paymentMethod) 
    {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() 
    {
        return paymentMethod;
    }

    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setOperatorId(Long operatorId) 
    {
        this.operatorId = operatorId;
    }

    public Long getOperatorId() 
    {
        return operatorId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("memberId", getMemberId())
            .append("courseId", getCourseId())
            .append("amount", getAmount())
            .append("paymentMethod", getPaymentMethod())
            .append("orderTime", getOrderTime())
            .append("status", getStatus())
            .append("operatorId", getOperatorId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
