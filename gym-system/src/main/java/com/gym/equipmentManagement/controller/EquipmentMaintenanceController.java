package com.gym.equipmentManagement.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gym.common.annotation.Log;
import com.gym.common.core.controller.BaseController;
import com.gym.common.core.domain.AjaxResult;
import com.gym.common.enums.BusinessType;
import com.gym.equipmentManagement.domain.EquipmentMaintenance;
import com.gym.equipmentManagement.service.IEquipmentMaintenanceService;
import com.gym.common.utils.poi.ExcelUtil;
import com.gym.common.core.page.TableDataInfo;

/**
 * 器材维护Controller
 * 
 * @author cqs
 * @date 2026-04-08
 */
@RestController
@RequestMapping("/equipmentManagement/maintenance")
public class EquipmentMaintenanceController extends BaseController
{
    @Autowired
    private IEquipmentMaintenanceService equipmentMaintenanceService;

    /**
     * 查询器材维护列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentManagement:maintenance:list')")
    @GetMapping("/list")
    public TableDataInfo list(EquipmentMaintenance equipmentMaintenance)
    {
        startPage();
        List<EquipmentMaintenance> list = equipmentMaintenanceService.selectEquipmentMaintenanceList(equipmentMaintenance);
        return getDataTable(list);
    }

    /**
     * 导出器材维护列表
     */
    @PreAuthorize("@ss.hasPermi('equipmentManagement:maintenance:export')")
    @Log(title = "器材维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EquipmentMaintenance equipmentMaintenance)
    {
        List<EquipmentMaintenance> list = equipmentMaintenanceService.selectEquipmentMaintenanceList(equipmentMaintenance);
        ExcelUtil<EquipmentMaintenance> util = new ExcelUtil<EquipmentMaintenance>(EquipmentMaintenance.class);
        util.exportExcel(response, list, "器材维护数据");
    }

    /**
     * 获取器材维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('equipmentManagement:maintenance:query')")
    @GetMapping(value = "/{maintenanceId}")
    public AjaxResult getInfo(@PathVariable("maintenanceId") Long maintenanceId)
    {
        return success(equipmentMaintenanceService.selectEquipmentMaintenanceByMaintenanceId(maintenanceId));
    }

    /**
     * 新增器材维护
     */
    @PreAuthorize("@ss.hasPermi('equipmentManagement:maintenance:add')")
    @Log(title = "器材维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EquipmentMaintenance equipmentMaintenance)
    {
        return toAjax(equipmentMaintenanceService.insertEquipmentMaintenance(equipmentMaintenance));
    }

    /**
     * 修改器材维护
     */
    @PreAuthorize("@ss.hasPermi('equipmentManagement:maintenance:edit')")
    @Log(title = "器材维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EquipmentMaintenance equipmentMaintenance)
    {
        return toAjax(equipmentMaintenanceService.updateEquipmentMaintenance(equipmentMaintenance));
    }

    /**
     * 删除器材维护
     */
    @PreAuthorize("@ss.hasPermi('equipmentManagement:maintenance:remove')")
    @Log(title = "器材维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{maintenanceIds}")
    public AjaxResult remove(@PathVariable Long[] maintenanceIds)
    {
        return toAjax(equipmentMaintenanceService.deleteEquipmentMaintenanceByMaintenanceIds(maintenanceIds));
    }
}
