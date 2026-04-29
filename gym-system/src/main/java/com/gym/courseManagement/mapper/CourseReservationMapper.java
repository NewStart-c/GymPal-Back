package com.gym.courseManagement.mapper;

import java.util.List;
import com.gym.courseManagement.domain.CourseReservation;

/**
 * 课程预约Mapper接口
 * 
 * @author cqs
 * @date 2026-04-08
 */
public interface CourseReservationMapper 
{
    /**
     * 查询课程预约
     * 
     * @param reservationId 课程预约主键
     * @return 课程预约
     */
    public CourseReservation selectCourseReservationByReservationId(Long reservationId);

    /**
     * 查询课程预约列表
     * 
     * @param courseReservation 课程预约
     * @return 课程预约集合
     */
    public List<CourseReservation> selectCourseReservationList(CourseReservation courseReservation);

    /**
     * 新增课程预约
     * 
     * @param courseReservation 课程预约
     * @return 结果
     */
    public int insertCourseReservation(CourseReservation courseReservation);

    /**
     * 修改课程预约
     * 
     * @param courseReservation 课程预约
     * @return 结果
     */
    public int updateCourseReservation(CourseReservation courseReservation);

    /**
     * 删除课程预约
     * 
     * @param reservationId 课程预约主键
     * @return 结果
     */
    public int deleteCourseReservationByReservationId(Long reservationId);

    /**
     * 批量删除课程预约
     * 
     * @param reservationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCourseReservationByReservationIds(Long[] reservationIds);

    public Long countReservationByTrainerId(Long trainerId);
}
