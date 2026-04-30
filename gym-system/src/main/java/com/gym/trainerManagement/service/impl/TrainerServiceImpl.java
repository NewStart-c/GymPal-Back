package com.gym.trainerManagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gym.common.core.domain.entity.SysUser;
import com.gym.common.utils.DateUtils;
import com.gym.common.utils.SecurityUtils;
import com.gym.system.domain.SysUserRole;
import com.gym.system.mapper.SysUserMapper;
import com.gym.system.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import com.gym.trainerManagement.mapper.TrainerMapper;
import com.gym.trainerManagement.domain.Trainer;
import com.gym.trainerManagement.service.ITrainerService;

/**
 * 教练管理Service业务层处理
 * 
 * @author cqs
 * @date 2026-04-08
 */
@Service
public class TrainerServiceImpl implements ITrainerService 
{
    @Autowired
    private TrainerMapper trainerMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 查询教练管理
     *
     * @param employeeId 教练管理主键
     * @return 教练管理
     */
    public Trainer selectTrainerByEmployeeId(Long employeeId){
        return trainerMapper.selectTrainerByEmployeeId(employeeId);
    }

    /**
     * 查询教练管理
     * 
     * @param trainerId 教练管理主键
     * @return 教练管理
     */
    @Override
    public Trainer selectTrainerByTrainerId(Long trainerId)
    {
        return trainerMapper.selectTrainerByTrainerId(trainerId);
    }

    /**
     * 查询教练管理列表
     * 
     * @param trainer 教练管理
     * @return 教练管理
     */
    @Override
    public List<Trainer> selectTrainerList(Trainer trainer)
    {
        return trainerMapper.selectTrainerList(trainer);
    }

    /**
     * 新增教练管理
     * 
     * @param trainer 教练管理
     * @return 结果
     */
    @Override
    public int insertTrainer(Trainer trainer)
    {
        trainer.setCreateTime(DateUtils.getNowDate());
        Long trainerId = trainerMapper.getLastTrainerId() + 1;
        String name = "trainer";
        Long userId = sysUserMapper.getLastSysUserId() + 1;

        SysUser user = new SysUser();
        user.setUserName(name + trainerId);    // 账号
        user.setPassword(SecurityUtils.encryptPassword(name + trainerId)); // 默认密码加密
        user.setNickName("教练");   // 昵称
        user.setDeptId(104L);                  // 部门ID（问我要）
        user.setUserId(userId);
        sysUserMapper.insertUser(user);

        trainer.setEmployeeId(userId);
        trainer.setTrainerId(trainerId);

        List<SysUserRole> sysUserRoles = new ArrayList<SysUserRole>();
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(userId);
        sysUserRole.setRoleId(100L);
        sysUserRoles.add(sysUserRole);
        sysUserRoleMapper.batchUserRole(sysUserRoles);

        return trainerMapper.insertTrainer(trainer);
    }

    /**
     * 修改教练管理
     * 
     * @param trainer 教练管理
     * @return 结果
     */
    @Override
    public int updateTrainer(Trainer trainer)
    {
        trainer.setUpdateTime(DateUtils.getNowDate());
        return trainerMapper.updateTrainer(trainer);
    }

    /**
     * 批量删除教练管理
     * 
     * @param trainerIds 需要删除的教练管理主键
     * @return 结果
     */
    @Override
    public int deleteTrainerByTrainerIds(Long[] trainerIds)
    {
        return trainerMapper.deleteTrainerByTrainerIds(trainerIds);
    }

    /**
     * 删除教练管理信息
     * 
     * @param trainerId 教练管理主键
     * @return 结果
     */
    @Override
    public int deleteTrainerByTrainerId(Long trainerId)
    {
        return trainerMapper.deleteTrainerByTrainerId(trainerId);
    }

    @Override
    public SysUser getTrainerSysInfo(Long employeeId){
        return sysUserMapper.selectUserById(employeeId);
    }
}
