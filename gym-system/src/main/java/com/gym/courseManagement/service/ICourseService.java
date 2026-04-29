package com.gym.courseManagement.service;

import java.util.List;
import com.gym.courseManagement.domain.Course;

/**
 * 课程信息Service接口
 * 
 * @author cqs
 * @date 2026-04-08
 */
public interface ICourseService 
{

    /**
     * trainerId计算课程数量
     */
    Long countCourseByTrainerId(Long trainerId);

    /**
     * 通过courseId使得课程预约人数+1
     */
    int updateCurrentEnrollmentAddOne(Long courseId);

    /**
     * 查询课程信息
     * 
     * @param courseId 课程信息主键
     * @return 课程信息
     */
    public Course selectCourseByCourseId(Long courseId);

    /**
     * 查询课程信息列表
     * 
     * @param course 课程信息
     * @return 课程信息集合
     */
    public List<Course> selectCourseList(Course course);

    /**
     * 新增课程信息
     * 
     * @param course 课程信息
     * @return 结果
     */
    public int insertCourse(Course course);

    /**
     * 修改课程信息
     * 
     * @param course 课程信息
     * @return 结果
     */
    public int updateCourse(Course course);

    /**
     * 批量删除课程信息
     * 
     * @param courseIds 需要删除的课程信息主键集合
     * @return 结果
     */
    public int deleteCourseByCourseIds(Long[] courseIds);

    /**
     * 删除课程信息信息
     * 
     * @param courseId 课程信息主键
     * @return 结果
     */
    public int deleteCourseByCourseId(Long courseId);
}
