package com.gym.courseManagement.service;

import java.util.List;
import com.gym.courseManagement.domain.CourseEvaluation;

/**
 * 课程评价Service接口
 * 
 * @author cqs
 * @date 2026-04-12
 */
public interface ICourseEvaluationService 
{
    /**
     * 查询课程评价
     * 
     * @param evaluationId 课程评价主键
     * @return 课程评价
     */
    public CourseEvaluation selectCourseEvaluationByEvaluationId(Long evaluationId);

    /**
     * 查询课程评价列表
     * 
     * @param courseEvaluation 课程评价
     * @return 课程评价集合
     */
    public List<CourseEvaluation> selectCourseEvaluationList(CourseEvaluation courseEvaluation);

    /**
     * 新增课程评价
     * 
     * @param courseEvaluation 课程评价
     * @return 结果
     */
    public int insertCourseEvaluation(CourseEvaluation courseEvaluation);

    /**
     * 修改课程评价
     * 
     * @param courseEvaluation 课程评价
     * @return 结果
     */
    public int updateCourseEvaluation(CourseEvaluation courseEvaluation);

    /**
     * 批量删除课程评价
     * 
     * @param evaluationIds 需要删除的课程评价主键集合
     * @return 结果
     */
    public int deleteCourseEvaluationByEvaluationIds(Long[] evaluationIds);

    /**
     * 删除课程评价信息
     * 
     * @param evaluationId 课程评价主键
     * @return 结果
     */
    public int deleteCourseEvaluationByEvaluationId(Long evaluationId);
}
