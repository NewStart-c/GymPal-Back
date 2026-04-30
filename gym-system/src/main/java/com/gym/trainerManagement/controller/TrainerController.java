package com.gym.trainerManagement.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.gym.common.core.domain.entity.SysUser;
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
import com.gym.trainerManagement.domain.Trainer;
import com.gym.trainerManagement.service.ITrainerService;
import com.gym.common.utils.poi.ExcelUtil;
import com.gym.common.core.page.TableDataInfo;

/**
 * 教练管理Controller
 * 
 * @author cqs
 * @date 2026-04-08
 */
@RestController
@RequestMapping("/trainerManagement/trainer")
public class TrainerController extends BaseController
{
    @Autowired
    private ITrainerService trainerService;

    /**
     * 查询教练管理列表
     */
//    @PreAuthorize("@ss.hasPermi('trainerManagement:trainer:list')")
    @GetMapping("/list")
    public TableDataInfo list(Trainer trainer)
    {
        startPage();
        List<Trainer> list = trainerService.selectTrainerList(trainer);
        return getDataTable(list);
    }

    /**
     * 查询教练个人user信息
     */
    @GetMapping("/profile/{employeeId}")
    public AjaxResult getTrainerSysInfo(@PathVariable Long employeeId){
        SysUser sysUser = trainerService.getTrainerSysInfo(employeeId);
        return success(sysUser);
    }

    /**
     * 导出教练管理列表
     */
//    @PreAuthorize("@ss.hasPermi('trainerManagement:trainer:export')")
    @Log(title = "教练管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Trainer trainer)
    {
        List<Trainer> list = trainerService.selectTrainerList(trainer);
        ExcelUtil<Trainer> util = new ExcelUtil<Trainer>(Trainer.class);
        util.exportExcel(response, list, "教练管理数据");
    }

    /**
     * 获取教练管理详细信息
     */
//    @PreAuthorize("@ss.hasPermi('trainerManagement:trainer:query')")
    @GetMapping(value = "/{trainerId}")
    public AjaxResult getInfo(@PathVariable("trainerId") Long trainerId)
    {
        return success(trainerService.selectTrainerByTrainerId(trainerId));
    }

    /**
     * 新增教练管理
     */
//    @PreAuthorize("@ss.hasPermi('trainerManagement:trainer:add')")
    @Log(title = "教练管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Trainer trainer)
    {
        return toAjax(trainerService.insertTrainer(trainer));
    }

    /**
     * 修改教练管理
     */
//    @PreAuthorize("@ss.hasPermi('trainerManagement:trainer:edit')")
    @Log(title = "教练管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Trainer trainer)
    {
        return toAjax(trainerService.updateTrainer(trainer));
    }

    /**
     * 删除教练管理
     */
//    @PreAuthorize("@ss.hasPermi('trainerManagement:trainer:remove')")
    @Log(title = "教练管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{trainerIds}")
    public AjaxResult remove(@PathVariable Long[] trainerIds)
    {
        return toAjax(trainerService.deleteTrainerByTrainerIds(trainerIds));
    }
}
