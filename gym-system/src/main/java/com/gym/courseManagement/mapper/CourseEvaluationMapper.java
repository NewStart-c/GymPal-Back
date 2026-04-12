package com.gym.courseManagement.mapper;

import java.util.List;
import com.gym.courseManagement.domain.CourseEvaluation;

/**
 * 课程评价Mapper接口
 * 
 * @author cqs
 * @date 2026-04-12
 */
public interface CourseEvaluationMapper 
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
     * 删除课程评价
     * 
     * @param evaluationId 课程评价主键
     * @return 结果
     */
    public int deleteCourseEvaluationByEvaluationId(Long evaluationId);

    /**
     * 批量删除课程评价
     * 
     * @param evaluationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCourseEvaluationByEvaluationIds(Long[] evaluationIds);
}
