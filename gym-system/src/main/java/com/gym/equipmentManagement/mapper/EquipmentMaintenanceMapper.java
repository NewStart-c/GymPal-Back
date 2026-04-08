package com.gym.equipmentManagement.mapper;

import java.util.List;
import com.gym.equipmentManagement.domain.EquipmentMaintenance;

/**
 * 器材维护Mapper接口
 * 
 * @author cqs
 * @date 2026-04-08
 */
public interface EquipmentMaintenanceMapper 
{
    /**
     * 查询器材维护
     * 
     * @param maintenanceId 器材维护主键
     * @return 器材维护
     */
    public EquipmentMaintenance selectEquipmentMaintenanceByMaintenanceId(Long maintenanceId);

    /**
     * 查询器材维护列表
     * 
     * @param equipmentMaintenance 器材维护
     * @return 器材维护集合
     */
    public List<EquipmentMaintenance> selectEquipmentMaintenanceList(EquipmentMaintenance equipmentMaintenance);

    /**
     * 新增器材维护
     * 
     * @param equipmentMaintenance 器材维护
     * @return 结果
     */
    public int insertEquipmentMaintenance(EquipmentMaintenance equipmentMaintenance);

    /**
     * 修改器材维护
     * 
     * @param equipmentMaintenance 器材维护
     * @return 结果
     */
    public int updateEquipmentMaintenance(EquipmentMaintenance equipmentMaintenance);

    /**
     * 删除器材维护
     * 
     * @param maintenanceId 器材维护主键
     * @return 结果
     */
    public int deleteEquipmentMaintenanceByMaintenanceId(Long maintenanceId);

    /**
     * 批量删除器材维护
     * 
     * @param maintenanceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEquipmentMaintenanceByMaintenanceIds(Long[] maintenanceIds);
}
