package com.gym.empManagement.controller;

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
import com.gym.empManagement.domain.EmpSchedule;
import com.gym.empManagement.service.IEmpScheduleService;
import com.gym.common.utils.poi.ExcelUtil;
import com.gym.common.core.page.TableDataInfo;

/**
 * 员工排班Controller
 * 
 * @author cqs
 * @date 2026-04-12
 */
@RestController
@RequestMapping("/empManagement/emp")
public class EmpScheduleController extends BaseController
{
    @Autowired
    private IEmpScheduleService empScheduleService;

    /**
     * 查询员工排班列表
     */
    @PreAuthorize("@ss.hasPermi('empManagement:emp:list')")
    @GetMapping("/list")
    public TableDataInfo list(EmpSchedule empSchedule)
    {
        startPage();
        List<EmpSchedule> list = empScheduleService.selectEmpScheduleList(empSchedule);
        return getDataTable(list);
    }

    /**
     * 导出员工排班列表
     */
    @PreAuthorize("@ss.hasPermi('empManagement:emp:export')")
    @Log(title = "员工排班", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EmpSchedule empSchedule)
    {
        List<EmpSchedule> list = empScheduleService.selectEmpScheduleList(empSchedule);
        ExcelUtil<EmpSchedule> util = new ExcelUtil<EmpSchedule>(EmpSchedule.class);
        util.exportExcel(response, list, "员工排班数据");
    }

    /**
     * 获取员工排班详细信息
     */
    @PreAuthorize("@ss.hasPermi('empManagement:emp:query')")
    @GetMapping(value = "/{scheduleId}")
    public AjaxResult getInfo(@PathVariable("scheduleId") Long scheduleId)
    {
        return success(empScheduleService.selectEmpScheduleByScheduleId(scheduleId));
    }

    /**
     * 新增员工排班
     */
    @PreAuthorize("@ss.hasPermi('empManagement:emp:add')")
    @Log(title = "员工排班", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EmpSchedule empSchedule)
    {
        return toAjax(empScheduleService.insertEmpSchedule(empSchedule));
    }

    /**
     * 修改员工排班
     */
    @PreAuthorize("@ss.hasPermi('empManagement:emp:edit')")
    @Log(title = "员工排班", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EmpSchedule empSchedule)
    {
        return toAjax(empScheduleService.updateEmpSchedule(empSchedule));
    }

    /**
     * 删除员工排班
     */
    @PreAuthorize("@ss.hasPermi('empManagement:emp:remove')")
    @Log(title = "员工排班", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scheduleIds}")
    public AjaxResult remove(@PathVariable Long[] scheduleIds)
    {
        return toAjax(empScheduleService.deleteEmpScheduleByScheduleIds(scheduleIds));
    }
}
