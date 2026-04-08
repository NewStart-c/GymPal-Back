package com.gym.memberManagement.service;

import java.util.List;
import com.gym.memberManagement.domain.MemberLevel;

/**
 * 会员等级Service接口
 * 
 * @author cqs
 * @date 2026-04-08
 */
public interface IMemberLevelService 
{
    /**
     * 查询会员等级
     * 
     * @param levelId 会员等级主键
     * @return 会员等级
     */
    public MemberLevel selectMemberLevelByLevelId(Long levelId);

    /**
     * 查询会员等级列表
     * 
     * @param memberLevel 会员等级
     * @return 会员等级集合
     */
    public List<MemberLevel> selectMemberLevelList(MemberLevel memberLevel);

    /**
     * 新增会员等级
     * 
     * @param memberLevel 会员等级
     * @return 结果
     */
    public int insertMemberLevel(MemberLevel memberLevel);

    /**
     * 修改会员等级
     * 
     * @param memberLevel 会员等级
     * @return 结果
     */
    public int updateMemberLevel(MemberLevel memberLevel);

    /**
     * 批量删除会员等级
     * 
     * @param levelIds 需要删除的会员等级主键集合
     * @return 结果
     */
    public int deleteMemberLevelByLevelIds(Long[] levelIds);

    /**
     * 删除会员等级信息
     * 
     * @param levelId 会员等级主键
     * @return 结果
     */
    public int deleteMemberLevelByLevelId(Long levelId);
}
