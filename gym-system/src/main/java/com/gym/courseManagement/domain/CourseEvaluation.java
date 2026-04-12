package com.gym.courseManagement.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gym.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gym.common.annotation.Excel;

/**
 * 课程评价对象 course_evaluation
 * 
 * @author cqs
 * @date 2026-04-12
 */
public class CourseEvaluation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评价ID */
    private Long evaluationId;

    /** 课程ID */
    @Excel(name = "课程ID")
    private Long courseId;

    /** 会员ID */
    @Excel(name = "会员ID")
    private Long memberId;

    /** 预约ID */
    @Excel(name = "预约ID")
    private Long reservationId;

    /** 评分(1-5分) */
    @Excel(name = "评分(1-5分)")
    private BigDecimal score;

    /** 评价内容 */
    @Excel(name = "评价内容")
    private String comment;

    /** 评价时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评价时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date evaluationTime;

    public void setEvaluationId(Long evaluationId) 
    {
        this.evaluationId = evaluationId;
    }

    public Long getEvaluationId() 
    {
        return evaluationId;
    }

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }

    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }

    public void setReservationId(Long reservationId) 
    {
        this.reservationId = reservationId;
    }

    public Long getReservationId() 
    {
        return reservationId;
    }

    public void setScore(BigDecimal score) 
    {
        this.score = score;
    }

    public BigDecimal getScore() 
    {
        return score;
    }

    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }

    public void setEvaluationTime(Date evaluationTime) 
    {
        this.evaluationTime = evaluationTime;
    }

    public Date getEvaluationTime() 
    {
        return evaluationTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("evaluationId", getEvaluationId())
            .append("courseId", getCourseId())
            .append("memberId", getMemberId())
            .append("reservationId", getReservationId())
            .append("score", getScore())
            .append("comment", getComment())
            .append("evaluationTime", getEvaluationTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
