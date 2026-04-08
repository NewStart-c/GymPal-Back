package com.gym.memberManagement.service.impl;

import java.util.List;
import com.gym.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gym.memberManagement.mapper.RechargeRecordMapper;
import com.gym.memberManagement.domain.RechargeRecord;
import com.gym.memberManagement.service.IRechargeRecordService;

/**
 * 储值记录Service业务层处理
 * 
 * @author cqs
 * @date 2026-04-08
 */
@Service
public class RechargeRecordServiceImpl implements IRechargeRecordService 
{
    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;

    /**
     * 查询储值记录
     * 
     * @param recordId 储值记录主键
     * @return 储值记录
     */
    @Override
    public RechargeRecord selectRechargeRecordByRecordId(Long recordId)
    {
        return rechargeRecordMapper.selectRechargeRecordByRecordId(recordId);
    }

    /**
     * 查询储值记录列表
     * 
     * @param rechargeRecord 储值记录
     * @return 储值记录
     */
    @Override
    public List<RechargeRecord> selectRechargeRecordList(RechargeRecord rechargeRecord)
    {
        return rechargeRecordMapper.selectRechargeRecordList(rechargeRecord);
    }

    /**
     * 新增储值记录
     * 
     * @param rechargeRecord 储值记录
     * @return 结果
     */
    @Override
    public int insertRechargeRecord(RechargeRecord rechargeRecord)
    {
        rechargeRecord.setCreateTime(DateUtils.getNowDate());
        return rechargeRecordMapper.insertRechargeRecord(rechargeRecord);
    }

    /**
     * 修改储值记录
     * 
     * @param rechargeRecord 储值记录
     * @return 结果
     */
    @Override
    public int updateRechargeRecord(RechargeRecord rechargeRecord)
    {
        rechargeRecord.setUpdateTime(DateUtils.getNowDate());
        return rechargeRecordMapper.updateRechargeRecord(rechargeRecord);
    }

    /**
     * 批量删除储值记录
     * 
     * @param recordIds 需要删除的储值记录主键
     * @return 结果
     */
    @Override
    public int deleteRechargeRecordByRecordIds(Long[] recordIds)
    {
        return rechargeRecordMapper.deleteRechargeRecordByRecordIds(recordIds);
    }

    /**
     * 删除储值记录信息
     * 
     * @param recordId 储值记录主键
     * @return 结果
     */
    @Override
    public int deleteRechargeRecordByRecordId(Long recordId)
    {
        return rechargeRecordMapper.deleteRechargeRecordByRecordId(recordId);
    }
}
