package com.gym.memberManagement.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gym.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gym.common.annotation.Excel;

/**
 * 储值记录对象 recharge_record
 * 
 * @author cqs
 * @date 2026-04-08
 */
public class RechargeRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long recordId;

    /** 会员ID */
    @Excel(name = "会员ID")
    private Long memberId;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal amount;

    /** 类型(0充值 1消费) */
    @Excel(name = "类型(0充值 1消费)")
    private String type;

    /** 支付方式 */
    @Excel(name = "支付方式")
    private String paymentMethod;

    /** 交易时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交易时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date transactionTime;

    /** 操作员ID */
    @Excel(name = "操作员ID")
    private Long operatorId;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }

    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }

    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    public void setPaymentMethod(String paymentMethod) 
    {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() 
    {
        return paymentMethod;
    }

    public void setTransactionTime(Date transactionTime) 
    {
        this.transactionTime = transactionTime;
    }

    public Date getTransactionTime() 
    {
        return transactionTime;
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
            .append("recordId", getRecordId())
            .append("memberId", getMemberId())
            .append("amount", getAmount())
            .append("type", getType())
            .append("paymentMethod", getPaymentMethod())
            .append("transactionTime", getTransactionTime())
            .append("operatorId", getOperatorId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
