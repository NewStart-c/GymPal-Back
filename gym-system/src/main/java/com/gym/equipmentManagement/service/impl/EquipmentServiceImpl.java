package com.gym.equipmentManagement.service.impl;

import java.util.List;
import com.gym.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gym.equipmentManagement.mapper.EquipmentMapper;
import com.gym.equipmentManagement.domain.Equipment;
import com.gym.equipmentManagement.service.IEquipmentService;

/**
 * 器材Service业务层处理
 * 
 * @author cqs
 * @date 2026-04-08
 */
@Service
public class EquipmentServiceImpl implements IEquipmentService 
{
    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * 查询器材
     * 
     * @param equipmentId 器材主键
     * @return 器材
     */
    @Override
    public Equipment selectEquipmentByEquipmentId(Long equipmentId)
    {
        return equipmentMapper.selectEquipmentByEquipmentId(equipmentId);
    }

    /**
     * 查询器材列表
     * 
     * @param equipment 器材
     * @return 器材
     */
    @Override
    public List<Equipment> selectEquipmentList(Equipment equipment)
    {
        return equipmentMapper.selectEquipmentList(equipment);
    }

    /**
     * 新增器材
     * 
     * @param equipment 器材
     * @return 结果
     */
    @Override
    public int insertEquipment(Equipment equipment)
    {
        equipment.setCreateTime(DateUtils.getNowDate());
        return equipmentMapper.insertEquipment(equipment);
    }

    /**
     * 修改器材
     * 
     * @param equipment 器材
     * @return 结果
     */
    @Override
    public int updateEquipment(Equipment equipment)
    {
        equipment.setUpdateTime(DateUtils.getNowDate());
        return equipmentMapper.updateEquipment(equipment);
    }

    /**
     * 批量删除器材
     * 
     * @param equipmentIds 需要删除的器材主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentByEquipmentIds(Long[] equipmentIds)
    {
        return equipmentMapper.deleteEquipmentByEquipmentIds(equipmentIds);
    }

    /**
     * 删除器材信息
     * 
     * @param equipmentId 器材主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentByEquipmentId(Long equipmentId)
    {
        return equipmentMapper.deleteEquipmentByEquipmentId(equipmentId);
    }
}
