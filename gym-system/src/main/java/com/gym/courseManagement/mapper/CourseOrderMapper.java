package com.gym.courseManagement.mapper;

import java.util.List;
import com.gym.courseManagement.domain.CourseOrder;

/**
 * 课程订单Mapper接口
 * 
 * @author cqs
 * @date 2026-04-12
 */
public interface CourseOrderMapper 
{
    /**
     * 查询课程订单
     * 
     * @param orderId 课程订单主键
     * @return 课程订单
     */
    public CourseOrder selectCourseOrderByOrderId(Long orderId);

    public List<CourseOrder> selectCourseOrderByCourseId(Long courseId);

    /**
     * 查询课程订单列表
     * 
     * @param courseOrder 课程订单
     * @return 课程订单集合
     */
    public List<CourseOrder> selectCourseOrderList(CourseOrder courseOrder);

    /**
     * 新增课程订单
     * 
     * @param courseOrder 课程订单
     * @return 结果
     */
    public int insertCourseOrder(CourseOrder courseOrder);

    /**
     * 修改课程订单
     * 
     * @param courseOrder 课程订单
     * @return 结果
     */
    public int updateCourseOrder(CourseOrder courseOrder);

    /**
     * 删除课程订单
     * 
     * @param orderId 课程订单主键
     * @return 结果
     */
    public int deleteCourseOrderByOrderId(Long orderId);

    /**
     * 批量删除课程订单
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCourseOrderByOrderIds(Long[] orderIds);
}
