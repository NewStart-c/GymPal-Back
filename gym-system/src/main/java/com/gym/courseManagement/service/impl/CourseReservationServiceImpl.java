package com.gym.courseManagement.service.impl;

import java.util.List;
import com.gym.common.utils.DateUtils;
import com.gym.courseManagement.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gym.courseManagement.mapper.CourseReservationMapper;
import com.gym.courseManagement.domain.CourseReservation;
import com.gym.courseManagement.service.ICourseReservationService;

/**
 * 课程预约Service业务层处理
 * 
 * @author cqs
 * @date 2026-04-08
 */
@Service
public class CourseReservationServiceImpl implements ICourseReservationService 
{
    @Autowired
    private CourseReservationMapper courseReservationMapper;
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Integer> getReservationLast7Days(Long tid) {
        return courseReservationMapper.getReservationLast7Days(tid);
    }
    /**
     * 查询课程预约
     *
     * @param trainerId 教练id
     * @return 课程预约
     */
    @Override
    public Long countReservationByTrainerId(Long trainerId) {
        return courseReservationMapper.countReservationByTrainerId(trainerId);
    }

    /**
     * 查询课程预约
     * 
     * @param reservationId 课程预约主键
     * @return 课程预约
     */
    @Override
    public CourseReservation selectCourseReservationByReservationId(Long reservationId)
    {
        return courseReservationMapper.selectCourseReservationByReservationId(reservationId);
    }

    /**
     * 查询课程预约列表
     * 
     * @param courseReservation 课程预约
     * @return 课程预约
     */
    @Override
    public List<CourseReservation> selectCourseReservationList(CourseReservation courseReservation)
    {
        return courseReservationMapper.selectCourseReservationList(courseReservation);
    }

    /**
     * 新增课程预约
     * 
     * @param courseReservation 课程预约
     * @return 结果
     */
    @Override
    public int insertCourseReservation(CourseReservation courseReservation)
    {
        courseReservation.setCreateTime(DateUtils.getNowDate());
        int rows = courseReservationMapper.insertCourseReservation(courseReservation);

        if(rows > 0){
            Long courseId = courseReservation.getCourseId();
            courseMapper.updateCurrentEnrollmentAddOne(courseId);
        }

        return rows;
    }

    /**
     * 修改课程预约
     * 
     * @param courseReservation 课程预约
     * @return 结果
     */
    @Override
    public int updateCourseReservation(CourseReservation courseReservation)
    {
        courseReservation.setUpdateTime(DateUtils.getNowDate());
        return courseReservationMapper.updateCourseReservation(courseReservation);
    }

    /**
     * 批量删除课程预约
     * 
     * @param reservationIds 需要删除的课程预约主键
     * @return 结果
     */
    @Override
    public int deleteCourseReservationByReservationIds(Long[] reservationIds)
    {
        return courseReservationMapper.deleteCourseReservationByReservationIds(reservationIds);
    }

    /**
     * 删除课程预约信息
     * 
     * @param reservationId 课程预约主键
     * @return 结果
     */
    @Override
    public int deleteCourseReservationByReservationId(Long reservationId)
    {
        return courseReservationMapper.deleteCourseReservationByReservationId(reservationId);
    }
}
