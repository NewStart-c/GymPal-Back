package com.gym.memberManagement.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gym.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gym.common.annotation.Excel;

/**
 * 会员管理对象 member
 * 
 * @author cqs
 * @date 2026-04-08
 */
public class Member extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会员ID */
    private Long memberId;

    /** 会员姓名 */
    @Excel(name = "会员姓名")
    private String name;

    /** 性别(0男 1女 2未知) */
    @Excel(name = "性别(0男 1女 2未知)")
    private String gender;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phoneNumber;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 注册日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date registrationDate;

    /** 会员等级ID */
    @Excel(name = "会员等级ID")
    private Long memberLevelId;

    /** 储值余额 */
    @Excel(name = "储值余额")
    private BigDecimal currentBalance;

    /** 状态(0正常 1冻结 2注销) */
    @Excel(name = "状态(0正常 1冻结 2注销)")
    private String status;

    private Long excludeMemberId;  // 用于校验手机号，排除自身

    public Long getExcludeMemberId() { return excludeMemberId; }
    public void setExcludeMemberId(Long excludeMemberId) { this.excludeMemberId = excludeMemberId; }


    private String keyword; // 搜索关键词（姓名/手机号）

    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * 充值金额
     */
    private BigDecimal rechargeAmount;

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }

    public void setRegistrationDate(Date registrationDate) 
    {
        this.registrationDate = registrationDate;
    }

    public Date getRegistrationDate() 
    {
        return registrationDate;
    }

    public void setMemberLevelId(Long memberLevelId) 
    {
        this.memberLevelId = memberLevelId;
    }

    public Long getMemberLevelId() 
    {
        return memberLevelId;
    }

    public void setCurrentBalance(BigDecimal currentBalance) 
    {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getCurrentBalance() 
    {
        return currentBalance;
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
            .append("memberId", getMemberId())
            .append("name", getName())
            .append("gender", getGender())
            .append("phoneNumber", getPhoneNumber())
            .append("birthday", getBirthday())
            .append("registrationDate", getRegistrationDate())
            .append("memberLevelId", getMemberLevelId())
            .append("currentBalance", getCurrentBalance())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
