package com.gym.equipmentManagement.service.impl;

import java.util.List;
import com.gym.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gym.equipmentManagement.mapper.EquipmentMaintenanceMapper;
import com.gym.equipmentManagement.domain.EquipmentMaintenance;
import com.gym.equipmentManagement.service.IEquipmentMaintenanceService;

/**
 * 器材维护Service业务层处理
 * 
 * @author cqs
 * @date 2026-04-08
 */
@Service
public class EquipmentMaintenanceServiceImpl implements IEquipmentMaintenanceService 
{
    @Autowired
    private EquipmentMaintenanceMapper equipmentMaintenanceMapper;

    /**
     * 查询器材维护
     * 
     * @param maintenanceId 器材维护主键
     * @return 器材维护
     */
    @Override
    public EquipmentMaintenance selectEquipmentMaintenanceByMaintenanceId(Long maintenanceId)
    {
        return equipmentMaintenanceMapper.selectEquipmentMaintenanceByMaintenanceId(maintenanceId);
    }

    /**
     * 查询器材维护列表
     * 
     * @param equipmentMaintenance 器材维护
     * @return 器材维护
     */
    @Override
    public List<EquipmentMaintenance> selectEquipmentMaintenanceList(EquipmentMaintenance equipmentMaintenance)
    {
        return equipmentMaintenanceMapper.selectEquipmentMaintenanceList(equipmentMaintenance);
    }

    /**
     * 新增器材维护
     * 
     * @param equipmentMaintenance 器材维护
     * @return 结果
     */
    @Override
    public int insertEquipmentMaintenance(EquipmentMaintenance equipmentMaintenance)
    {
        equipmentMaintenance.setCreateTime(DateUtils.getNowDate());
        return equipmentMaintenanceMapper.insertEquipmentMaintenance(equipmentMaintenance);
    }

    /**
     * 修改器材维护
     * 
     * @param equipmentMaintenance 器材维护
     * @return 结果
     */
    @Override
    public int updateEquipmentMaintenance(EquipmentMaintenance equipmentMaintenance)
    {
        equipmentMaintenance.setUpdateTime(DateUtils.getNowDate());
        return equipmentMaintenanceMapper.updateEquipmentMaintenance(equipmentMaintenance);
    }

    /**
     * 批量删除器材维护
     * 
     * @param maintenanceIds 需要删除的器材维护主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentMaintenanceByMaintenanceIds(Long[] maintenanceIds)
    {
        return equipmentMaintenanceMapper.deleteEquipmentMaintenanceByMaintenanceIds(maintenanceIds);
    }

    /**
     * 删除器材维护信息
     * 
     * @param maintenanceId 器材维护主键
     * @return 结果
     */
    @Override
    public int deleteEquipmentMaintenanceByMaintenanceId(Long maintenanceId)
    {
        return equipmentMaintenanceMapper.deleteEquipmentMaintenanceByMaintenanceId(maintenanceId);
    }
}
