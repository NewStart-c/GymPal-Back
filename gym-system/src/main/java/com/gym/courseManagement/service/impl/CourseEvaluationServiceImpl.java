package com.gym.courseManagement.service.impl;

import java.util.List;
import com.gym.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gym.courseManagement.mapper.CourseEvaluationMapper;
import com.gym.courseManagement.domain.CourseEvaluation;
import com.gym.courseManagement.service.ICourseEvaluationService;

/**
 * 课程评价Service业务层处理
 * 
 * @author cqs
 * @date 2026-04-12
 */
@Service
public class CourseEvaluationServiceImpl implements ICourseEvaluationService 
{
    @Autowired
    private CourseEvaluationMapper courseEvaluationMapper;

    /**
     * 查询课程评价
     * 
     * @param evaluationId 课程评价主键
     * @return 课程评价
     */
    @Override
    public CourseEvaluation selectCourseEvaluationByEvaluationId(Long evaluationId)
    {
        return courseEvaluationMapper.selectCourseEvaluationByEvaluationId(evaluationId);
    }

    /**
     * 查询课程评价列表
     * 
     * @param courseEvaluation 课程评价
     * @return 课程评价
     */
    @Override
    public List<CourseEvaluation> selectCourseEvaluationList(CourseEvaluation courseEvaluation)
    {
        return courseEvaluationMapper.selectCourseEvaluationList(courseEvaluation);
    }

    /**
     * 新增课程评价
     * 
     * @param courseEvaluation 课程评价
     * @return 结果
     */
    @Override
    public int insertCourseEvaluation(CourseEvaluation courseEvaluation)
    {
        courseEvaluation.setCreateTime(DateUtils.getNowDate());
        return courseEvaluationMapper.insertCourseEvaluation(courseEvaluation);
    }

    /**
     * 修改课程评价
     * 
     * @param courseEvaluation 课程评价
     * @return 结果
     */
    @Override
    public int updateCourseEvaluation(CourseEvaluation courseEvaluation)
    {
        courseEvaluation.setUpdateTime(DateUtils.getNowDate());
        return courseEvaluationMapper.updateCourseEvaluation(courseEvaluation);
    }

    /**
     * 批量删除课程评价
     * 
     * @param evaluationIds 需要删除的课程评价主键
     * @return 结果
     */
    @Override
    public int deleteCourseEvaluationByEvaluationIds(Long[] evaluationIds)
    {
        return courseEvaluationMapper.deleteCourseEvaluationByEvaluationIds(evaluationIds);
    }

    /**
     * 删除课程评价信息
     * 
     * @param evaluationId 课程评价主键
     * @return 结果
     */
    @Override
    public int deleteCourseEvaluationByEvaluationId(Long evaluationId)
    {
        return courseEvaluationMapper.deleteCourseEvaluationByEvaluationId(evaluationId);
    }
}
