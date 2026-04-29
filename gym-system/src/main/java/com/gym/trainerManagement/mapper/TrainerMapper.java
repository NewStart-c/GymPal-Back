package com.gym.trainerManagement.mapper;

import java.util.List;
import com.gym.trainerManagement.domain.Trainer;

/**
 * 教练管理Mapper接口
 * 
 * @author cqs
 * @date 2026-04-08
 */
public interface TrainerMapper 
{
    /**
     * 查询教练管理
     * 
     * @param trainerId 教练管理主键
     * @return 教练管理
     */
    public Trainer selectTrainerByTrainerId(Long trainerId);

    /**
     * 查询教练管理列表
     * 
     * @param trainer 教练管理
     * @return 教练管理集合
     */
    public List<Trainer> selectTrainerList(Trainer trainer);

    /**
     * 新增教练管理
     * 
     * @param trainer 教练管理
     * @return 结果
     */
    public int insertTrainer(Trainer trainer);

    /**
     * 修改教练管理
     * 
     * @param trainer 教练管理
     * @return 结果
     */
    public int updateTrainer(Trainer trainer);

    /**
     * 删除教练管理
     * 
     * @param trainerId 教练管理主键
     * @return 结果
     */
    public int deleteTrainerByTrainerId(Long trainerId);

    /**
     * 批量删除教练管理
     * 
     * @param trainerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrainerByTrainerIds(Long[] trainerIds);

    /**
     * 查询教练管理
     *
     * @param employeeId 教练管理主键
     * @return 教练管理
     */
    public Trainer selectTrainerByEmployeeId(Long employeeId);
}
