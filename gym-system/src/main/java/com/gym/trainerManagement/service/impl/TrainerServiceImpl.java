package com.gym.trainerManagement.service.impl;

import java.util.List;
import com.gym.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
}
