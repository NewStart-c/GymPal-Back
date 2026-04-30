package com.gym.courseManagement.service.impl;

import java.util.List;
import com.gym.common.utils.DateUtils;
import com.gym.courseManagement.domain.Course;
import com.gym.courseManagement.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gym.courseManagement.mapper.CourseOrderMapper;
import com.gym.courseManagement.domain.CourseOrder;
import com.gym.courseManagement.service.ICourseOrderService;

/**
 * 课程订单Service业务层处理
 * 
 * @author cqs
 * @date 2026-04-12
 */
@Service
public class CourseOrderServiceImpl implements ICourseOrderService 
{
    @Autowired
    private CourseOrderMapper courseOrderMapper;

    @Autowired
    private CourseMapper courseMapper;

    /**
     * 查询课程订单
     * 
     * @param orderId 课程订单主键
     * @return 课程订单
     */
    @Override
    public CourseOrder selectCourseOrderByOrderId(Long orderId)
    {
        return courseOrderMapper.selectCourseOrderByOrderId(orderId);
    }

    /**
     * 查询课程订单列表
     * 
     * @param courseOrder 课程订单
     * @return 课程订单
     */
    @Override
    public List<CourseOrder> selectCourseOrderList(CourseOrder courseOrder)
    {
        return courseOrderMapper.selectCourseOrderList(courseOrder);
    }

    /**
     * 新增课程订单
     * 
     * @param courseOrder 课程订单
     * @return 结果
     */
    @Override
    public int insertCourseOrder(CourseOrder courseOrder)
    {
        courseOrder.setCreateTime(DateUtils.getNowDate());
        return courseOrderMapper.insertCourseOrder(courseOrder);
    }

    /**
     * 修改课程订单
     * 
     * @param courseOrder 课程订单
     * @return 结果
     */
    @Override
    public int updateCourseOrder(CourseOrder courseOrder)
    {
        courseOrder.setUpdateTime(DateUtils.getNowDate());
        return courseOrderMapper.updateCourseOrder(courseOrder);
    }

    /**
     * 批量删除课程订单
     * 
     * @param orderIds 需要删除的课程订单主键
     * @return 结果
     */
    @Override
    public int deleteCourseOrderByOrderIds(Long[] orderIds)
    {
        return courseOrderMapper.deleteCourseOrderByOrderIds(orderIds);
    }

    /**
     * 删除课程订单信息
     * 
     * @param orderId 课程订单主键
     * @return 结果
     */
    @Override
    public int deleteCourseOrderByOrderId(Long orderId)
    {
        return courseOrderMapper.deleteCourseOrderByOrderId(orderId);
    }

    /**
     * 教练课程收入
     *
     * @param tid 课程订单主键
     * @return 教练收入
     */
    public double getMoneyByTrainerId(Long tid){
        List<Course> courseList = courseMapper.selectCourseListByTrainerId(tid);
        double trainerMoney = 1.0;
        for(Course c : courseList){
            System.out.println("课程:" + c.getCourseId());
            List<CourseOrder> courseOrder = courseOrderMapper.selectCourseOrderByCourseId(c.getCourseId());
            for (CourseOrder co : courseOrder){
                System.out.println("订单:" + co.getOrderId());
                double money = co.getAmount().doubleValue();
                if(money != 0.0)
                    trainerMoney += money;
            }
        }
        trainerMoney *= 0.7; // 分成默认0.7
        System.out.println("结果是多少：" + trainerMoney);
        return trainerMoney;
    }
}
