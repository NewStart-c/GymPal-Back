package com.gym.trainerManagement.service.impl;

import java.util.List;
import com.gym.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gym.trainerManagement.mapper.TrainerEvaluationMapper;
import com.gym.trainerManagement.domain.TrainerEvaluation;
import com.gym.trainerManagement.service.ITrainerEvaluationService;

/**
 * 教练评价Service业务层处理
 * 
 * @author cqs
 * @date 2026-04-08
 */
@Service
public class TrainerEvaluationServiceImpl implements ITrainerEvaluationService 
{
    @Autowired
    private TrainerEvaluationMapper trainerEvaluationMapper;


    /**
     * 统计教练课程平均分
     *
     * @param trainerId 教练评价主键
     * @return 统计平均分
     */
    @Override
    public double getAvgScoreByTrainerId(Long trainerId) {
        Double avg = trainerEvaluationMapper.getAvgScoreByTrainerId(trainerId);
        return avg == null ? 0 : avg;
    }


    /**
     * 查询教练评价
     * 
     * @param evaluationId 教练评价主键
     * @return 教练评价
     */
    @Override
    public TrainerEvaluation selectTrainerEvaluationByEvaluationId(Long evaluationId)
    {
        return trainerEvaluationMapper.selectTrainerEvaluationByEvaluationId(evaluationId);
    }

    /**
     * 查询教练评价列表
     * 
     * @param trainerEvaluation 教练评价
     * @return 教练评价
     */
    @Override
    public List<TrainerEvaluation> selectTrainerEvaluationList(TrainerEvaluation trainerEvaluation)
    {
        return trainerEvaluationMapper.selectTrainerEvaluationList(trainerEvaluation);
    }

    /**
     * 新增教练评价
     * 
     * @param trainerEvaluation 教练评价
     * @return 结果
     */
    @Override
    public int insertTrainerEvaluation(TrainerEvaluation trainerEvaluation)
    {
        trainerEvaluation.setCreateTime(DateUtils.getNowDate());
        trainerEvaluation.setEvaluationTime(DateUtils.getNowDate());
        return trainerEvaluationMapper.insertTrainerEvaluation(trainerEvaluation);
    }

    /**
     * 修改教练评价
     * 
     * @param trainerEvaluation 教练评价
     * @return 结果
     */
    @Override
    public int updateTrainerEvaluation(TrainerEvaluation trainerEvaluation)
    {
        trainerEvaluation.setUpdateTime(DateUtils.getNowDate());
        return trainerEvaluationMapper.updateTrainerEvaluation(trainerEvaluation);
    }

    /**
     * 批量删除教练评价
     * 
     * @param evaluationIds 需要删除的教练评价主键
     * @return 结果
     */
    @Override
    public int deleteTrainerEvaluationByEvaluationIds(Long[] evaluationIds)
    {
        return trainerEvaluationMapper.deleteTrainerEvaluationByEvaluationIds(evaluationIds);
    }

    /**
     * 删除教练评价信息
     * 
     * @param evaluationId 教练评价主键
     * @return 结果
     */
    @Override
    public int deleteTrainerEvaluationByEvaluationId(Long evaluationId)
    {
        return trainerEvaluationMapper.deleteTrainerEvaluationByEvaluationId(evaluationId);
    }
}
