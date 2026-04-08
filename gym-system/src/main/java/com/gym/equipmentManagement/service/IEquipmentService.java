package com.gym.equipmentManagement.service;

import java.util.List;
import com.gym.equipmentManagement.domain.Equipment;

/**
 * 器材Service接口
 * 
 * @author cqs
 * @date 2026-04-08
 */
public interface IEquipmentService 
{
    /**
     * 查询器材
     * 
     * @param equipmentId 器材主键
     * @return 器材
     */
    public Equipment selectEquipmentByEquipmentId(Long equipmentId);

    /**
     * 查询器材列表
     * 
     * @param equipment 器材
     * @return 器材集合
     */
    public List<Equipment> selectEquipmentList(Equipment equipment);

    /**
     * 新增器材
     * 
     * @param equipment 器材
     * @return 结果
     */
    public int insertEquipment(Equipment equipment);

    /**
     * 修改器材
     * 
     * @param equipment 器材
     * @return 结果
     */
    public int updateEquipment(Equipment equipment);

    /**
     * 批量删除器材
     * 
     * @param equipmentIds 需要删除的器材主键集合
     * @return 结果
     */
    public int deleteEquipmentByEquipmentIds(Long[] equipmentIds);

    /**
     * 删除器材信息
     * 
     * @param equipmentId 器材主键
     * @return 结果
     */
    public int deleteEquipmentByEquipmentId(Long equipmentId);
}
