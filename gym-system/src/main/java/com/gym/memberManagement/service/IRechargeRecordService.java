package com.gym.memberManagement.service;

import java.util.List;
import com.gym.memberManagement.domain.RechargeRecord;

/**
 * 储值记录Service接口
 * 
 * @author cqs
 * @date 2026-04-08
 */
public interface IRechargeRecordService 
{
    /**
     * 查询储值记录
     * 
     * @param recordId 储值记录主键
     * @return 储值记录
     */
    public RechargeRecord selectRechargeRecordByRecordId(Long recordId);

    /**
     * 查询储值记录列表
     * 
     * @param rechargeRecord 储值记录
     * @return 储值记录集合
     */
    public List<RechargeRecord> selectRechargeRecordList(RechargeRecord rechargeRecord);

    /**
     * 新增储值记录
     * 
     * @param rechargeRecord 储值记录
     * @return 结果
     */
    public int insertRechargeRecord(RechargeRecord rechargeRecord);

    /**
     * 修改储值记录
     * 
     * @param rechargeRecord 储值记录
     * @return 结果
     */
    public int updateRechargeRecord(RechargeRecord rechargeRecord);

    /**
     * 批量删除储值记录
     * 
     * @param recordIds 需要删除的储值记录主键集合
     * @return 结果
     */
    public int deleteRechargeRecordByRecordIds(Long[] recordIds);

    /**
     * 删除储值记录信息
     * 
     * @param recordId 储值记录主键
     * @return 结果
     */
    public int deleteRechargeRecordByRecordId(Long recordId);
}
