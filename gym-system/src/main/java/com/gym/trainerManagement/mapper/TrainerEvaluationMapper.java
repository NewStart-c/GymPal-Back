package com.gym.trainerManagement.mapper;

import java.util.List;
import com.gym.trainerManagement.domain.TrainerEvaluation;

/**
 * 教练评价Mapper接口
 * 
 * @author cqs
 * @date 2026-04-08
 */
public interface TrainerEvaluationMapper 
{

    

    /**
     * 查询教练评价
     * 
     * @param evaluationId 教练评价主键
     * @return 教练评价
     */
    public TrainerEvaluation selectTrainerEvaluationByEvaluationId(Long evaluationId);

    /**
     * 查询教练评价列表
     * 
     * @param trainerEvaluation 教练评价
     * @return 教练评价集合
     */
    public List<TrainerEvaluation> selectTrainerEvaluationList(TrainerEvaluation trainerEvaluation);

    /**
     * 新增教练评价
     * 
     * @param trainerEvaluation 教练评价
     * @return 结果
     */
    public int insertTrainerEvaluation(TrainerEvaluation trainerEvaluation);

    /**
     * 修改教练评价
     * 
     * @param trainerEvaluation 教练评价
     * @return 结果
     */
    public int updateTrainerEvaluation(TrainerEvaluation trainerEvaluation);

    /**
     * 删除教练评价
     * 
     * @param evaluationId 教练评价主键
     * @return 结果
     */
    public int deleteTrainerEvaluationByEvaluationId(Long evaluationId);

    /**
     * 批量删除教练评价
     * 
     * @param evaluationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrainerEvaluationByEvaluationIds(Long[] evaluationIds);

    public Double getAvgScoreByTrainerId(Long trainerId);
}
