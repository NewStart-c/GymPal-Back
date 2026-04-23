package com.gym.courseManagement.service.impl;

import java.util.List;
import com.gym.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gym.courseManagement.mapper.CourseMapper;
import com.gym.courseManagement.domain.Course;
import com.gym.courseManagement.service.ICourseService;

/**
 * 课程信息Service业务层处理
 * 
 * @author cqs
 * @date 2026-04-08
 */
@Service
public class CourseServiceImpl implements ICourseService 
{
    @Autowired
    private CourseMapper courseMapper;

    /**
     * 通过courseId使得课程预约人数+1
     */
    @Override
    public int updateCurrentEnrollmentAddOne(Long courseId){
        return courseMapper.updateCurrentEnrollmentAddOne(courseId);
    }


    /**
     * 查询课程信息
     * 
     * @param courseId 课程信息主键
     * @return 课程信息
     */
    @Override
    public Course selectCourseByCourseId(Long courseId)
    {
        return courseMapper.selectCourseByCourseId(courseId);
    }

    /**
     * 查询课程信息列表
     * 
     * @param course 课程信息
     * @return 课程信息
     */
    @Override
    public List<Course> selectCourseList(Course course)
    {
        return courseMapper.selectCourseList(course);
    }

    /**
     * 新增课程信息
     * 
     * @param course 课程信息
     * @return 结果
     */
    @Override
    public int insertCourse(Course course)
    {
        course.setCreateTime(DateUtils.getNowDate());
        return courseMapper.insertCourse(course);
    }

    /**
     * 修改课程信息
     * 
     * @param course 课程信息
     * @return 结果
     */
    @Override
    public int updateCourse(Course course)
    {
        course.setUpdateTime(DateUtils.getNowDate());
        return courseMapper.updateCourse(course);
    }

    /**
     * 批量删除课程信息
     * 
     * @param courseIds 需要删除的课程信息主键
     * @return 结果
     */
    @Override
    public int deleteCourseByCourseIds(Long[] courseIds)
    {
        return courseMapper.deleteCourseByCourseIds(courseIds);
    }

    /**
     * 删除课程信息信息
     * 
     * @param courseId 课程信息主键
     * @return 结果
     */
    @Override
    public int deleteCourseByCourseId(Long courseId)
    {
        return courseMapper.deleteCourseByCourseId(courseId);
    }
}
