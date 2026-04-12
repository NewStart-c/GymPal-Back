package com.gym.empManagement.mapper;

import java.util.List;
import com.gym.empManagement.domain.EmpSchedule;

/**
 * 员工排班Mapper接口
 * 
 * @author cqs
 * @date 2026-04-12
 */
public interface EmpScheduleMapper 
{
    /**
     * 查询员工排班
     * 
     * @param scheduleId 员工排班主键
     * @return 员工排班
     */
    public EmpSchedule selectEmpScheduleByScheduleId(Long scheduleId);

    /**
     * 查询员工排班列表
     * 
     * @param empSchedule 员工排班
     * @return 员工排班集合
     */
    public List<EmpSchedule> selectEmpScheduleList(EmpSchedule empSchedule);

    /**
     * 新增员工排班
     * 
     * @param empSchedule 员工排班
     * @return 结果
     */
    public int insertEmpSchedule(EmpSchedule empSchedule);

    /**
     * 修改员工排班
     * 
     * @param empSchedule 员工排班
     * @return 结果
     */
    public int updateEmpSchedule(EmpSchedule empSchedule);

    /**
     * 删除员工排班
     * 
     * @param scheduleId 员工排班主键
     * @return 结果
     */
    public int deleteEmpScheduleByScheduleId(Long scheduleId);

    /**
     * 批量删除员工排班
     * 
     * @param scheduleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEmpScheduleByScheduleIds(Long[] scheduleIds);
}
