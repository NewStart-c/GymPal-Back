package com.gym.memberManagement.service.impl;

import java.lang.invoke.LambdaConversionException;
import java.math.BigDecimal;
import java.util.List;

import com.gym.common.core.domain.entity.SysUser;
import com.gym.common.exception.ServiceException;
import com.gym.common.utils.DateUtils;
import com.gym.common.utils.SecurityUtils;
import com.gym.memberManagement.domain.RechargeRecord;
import com.gym.memberManagement.service.IRechargeRecordService;
import com.gym.system.mapper.SysUserMapper;
import com.gym.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gym.memberManagement.mapper.MemberMapper;
import com.gym.memberManagement.domain.Member;
import com.gym.memberManagement.service.IMemberService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员管理Service业务层处理
 * 
 * @author cqs
 * @date 2026-04-08
 */
@Service
public class MemberServiceImpl implements IMemberService 
{
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private IRechargeRecordService rechargeRecordService;

    /**
     * 查询会员管理
     * 
     * @param memberId 会员管理主键
     * @return 会员管理
     */
    @Override
    public Member selectMemberByMemberId(Long memberId)
    {
        return memberMapper.selectMemberByMemberId(memberId);
    }

    /**
     * 查询会员管理列表
     * 
     * @param member 会员管理
     * @return 会员管理
     */
    @Override
    public List<Member> selectMemberList(Member member)
    {
        return memberMapper.selectMemberList(member);
    }

    /**
     * 新增会员管理
     * 
     * @param member 会员管理
     * @return 结果
     */
    @Override
    public int insertMember(Member member)
    {
        member.setCreateTime(DateUtils.getNowDate());
        int rows = memberMapper.insertMember(member);

        if(rows > 0){
            SysUser sysUser = new SysUser();
            sysUser.setUserName(member.getPhoneNumber());
            sysUser.setNickName(member.getName());
            // 加密默认密码为123456
            sysUser.setPassword(SecurityUtils.encryptPassword("123456"));
            sysUser.setPhonenumber(member.getPhoneNumber());
            sysUser.setStatus("0");
            sysUser.setSex(member.getGender());

            // 默认200 用户部门
            sysUser.setDeptId(201L);

            // 默认201 用户角色
            Long[] roleIds = {200L};
            sysUser.setRoleIds(roleIds);

            int row = sysUserService.insertUser(sysUser);
            System.out.println("==============这个返回的值是:" + row +"=================");
        }

        return rows;
    }

    /**
     * 修改会员管理
     * 
     * @param member 会员管理
     * @return 结果
     */
    @Override
    public int updateMember(Member member)
    {

        member.setUpdateTime(DateUtils.getNowDate());
        Member old = selectMemberByMemberId(member.getMemberId());
        String number = old.getPhoneNumber();

        int rows = memberMapper.updateMember(member);

        // 确保数据的一致性
        if(rows > 0){

            SysUser sysUser = sysUserService.selectUserByUserName(number);
            System.out.println("检查是否执行===" + sysUser.getUserName());
            sysUser.setPhonenumber(member.getPhoneNumber());
            sysUser.setUserName(member.getPhoneNumber());
            sysUserMapper.updateUser(sysUser);
            System.out.println("检查是否执行===" + sysUser.getUserName());
        }

        return rows;
    }

    /**
     * 批量删除会员管理
     * 
     * @param memberIds 需要删除的会员管理主键
     * @return 结果
     */
    @Override
    public int deleteMemberByMemberIds(Long[] memberIds)
    {
        return memberMapper.deleteMemberByMemberIds(memberIds);
    }

    /**
     * 删除会员管理信息
     * 
     * @param memberId 会员管理主键
     * @return 结果
     */
    @Override
    public int deleteMemberByMemberId(Long memberId)
    {
        return memberMapper.deleteMemberByMemberId(memberId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int rechargeMember(Member member) {

        // 计算新余额 = 原余额 + 充值金额
        BigDecimal newBalance = member.getCurrentBalance().add(member.getRechargeAmount());
        member.setCurrentBalance(newBalance);
        // 更新会员余额
        int rows = memberMapper.updateMember(member);

        // 插入充值记录表（强烈建议加）
        RechargeRecord record = new RechargeRecord();
        record.setMemberId(member.getMemberId());
        record.setAmount(member.getRechargeAmount()); //充值金额
        record.setCreateTime(DateUtils.getNowDate());
        record.setType("0"); //充值记录
        record.setPaymentMethod("线下支付");
        record.setRemark(member.getRemark());
        record.setTransactionTime(record.getCreateTime());
        record.setOperatorId(SecurityUtils.getUserId());
        rechargeRecordService.insertRechargeRecord(record);

        return rows;
    }
}
