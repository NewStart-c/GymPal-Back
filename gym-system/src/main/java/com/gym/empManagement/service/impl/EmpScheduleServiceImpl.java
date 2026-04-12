package com.gym.empManagement.service.impl;

import java.util.List;
import com.gym.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gym.empManagement.mapper.EmpScheduleMapper;
import com.gym.empManagement.domain.EmpSchedule;
import com.gym.empManagement.service.IEmpScheduleService;

/**
 * 员工排班Service业务层处理
 * 
 * @author cqs
 * @date 2026-04-12
 */
@Service
public class EmpScheduleServiceImpl implements IEmpScheduleService 
{
    @Autowired
    private EmpScheduleMapper empScheduleMapper;

    /**
     * 查询员工排班
     * 
     * @param scheduleId 员工排班主键
     * @return 员工排班
     */
    @Override
    public EmpSchedule selectEmpScheduleByScheduleId(Long scheduleId)
    {
        return empScheduleMapper.selectEmpScheduleByScheduleId(scheduleId);
    }

    /**
     * 查询员工排班列表
     * 
     * @param empSchedule 员工排班
     * @return 员工排班
     */
    @Override
    public List<EmpSchedule> selectEmpScheduleList(EmpSchedule empSchedule)
    {
        return empScheduleMapper.selectEmpScheduleList(empSchedule);
    }

    /**
     * 新增员工排班
     * 
     * @param empSchedule 员工排班
     * @return 结果
     */
    @Override
    public int insertEmpSchedule(EmpSchedule empSchedule)
    {
        empSchedule.setCreateTime(DateUtils.getNowDate());
        return empScheduleMapper.insertEmpSchedule(empSchedule);
    }

    /**
     * 修改员工排班
     * 
     * @param empSchedule 员工排班
     * @return 结果
     */
    @Override
    public int updateEmpSchedule(EmpSchedule empSchedule)
    {
        empSchedule.setUpdateTime(DateUtils.getNowDate());
        return empScheduleMapper.updateEmpSchedule(empSchedule);
    }

    /**
     * 批量删除员工排班
     * 
     * @param scheduleIds 需要删除的员工排班主键
     * @return 结果
     */
    @Override
    public int deleteEmpScheduleByScheduleIds(Long[] scheduleIds)
    {
        return empScheduleMapper.deleteEmpScheduleByScheduleIds(scheduleIds);
    }

    /**
     * 删除员工排班信息
     * 
     * @param scheduleId 员工排班主键
     * @return 结果
     */
    @Override
    public int deleteEmpScheduleByScheduleId(Long scheduleId)
    {
        return empScheduleMapper.deleteEmpScheduleByScheduleId(scheduleId);
    }
}
