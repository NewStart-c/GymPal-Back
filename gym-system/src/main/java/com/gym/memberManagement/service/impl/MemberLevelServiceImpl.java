package com.gym.memberManagement.service.impl;

import java.util.List;
import com.gym.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gym.memberManagement.mapper.MemberLevelMapper;
import com.gym.memberManagement.domain.MemberLevel;
import com.gym.memberManagement.service.IMemberLevelService;

/**
 * 会员等级Service业务层处理
 * 
 * @author cqs
 * @date 2026-04-08
 */
@Service
public class MemberLevelServiceImpl implements IMemberLevelService 
{
    @Autowired
    private MemberLevelMapper memberLevelMapper;

    /**
     * 查询会员等级
     * 
     * @param levelId 会员等级主键
     * @return 会员等级
     */
    @Override
    public MemberLevel selectMemberLevelByLevelId(Long levelId)
    {
        return memberLevelMapper.selectMemberLevelByLevelId(levelId);
    }

    /**
     * 查询会员等级列表
     * 
     * @param memberLevel 会员等级
     * @return 会员等级
     */
    @Override
    public List<MemberLevel> selectMemberLevelList(MemberLevel memberLevel)
    {
        return memberLevelMapper.selectMemberLevelList(memberLevel);
    }

    /**
     * 新增会员等级
     * 
     * @param memberLevel 会员等级
     * @return 结果
     */
    @Override
    public int insertMemberLevel(MemberLevel memberLevel)
    {
        memberLevel.setCreateTime(DateUtils.getNowDate());
        return memberLevelMapper.insertMemberLevel(memberLevel);
    }

    /**
     * 修改会员等级
     * 
     * @param memberLevel 会员等级
     * @return 结果
     */
    @Override
    public int updateMemberLevel(MemberLevel memberLevel)
    {
        memberLevel.setUpdateTime(DateUtils.getNowDate());
        return memberLevelMapper.updateMemberLevel(memberLevel);
    }

    /**
     * 批量删除会员等级
     * 
     * @param levelIds 需要删除的会员等级主键
     * @return 结果
     */
    @Override
    public int deleteMemberLevelByLevelIds(Long[] levelIds)
    {
        return memberLevelMapper.deleteMemberLevelByLevelIds(levelIds);
    }

    /**
     * 删除会员等级信息
     * 
     * @param levelId 会员等级主键
     * @return 结果
     */
    @Override
    public int deleteMemberLevelByLevelId(Long levelId)
    {
        return memberLevelMapper.deleteMemberLevelByLevelId(levelId);
    }
}
