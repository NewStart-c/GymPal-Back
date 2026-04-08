package com.gym.trainerManagement.controller;

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
import com.gym.trainerManagement.domain.TrainerEvaluation;
import com.gym.trainerManagement.service.ITrainerEvaluationService;
import com.gym.common.utils.poi.ExcelUtil;
import com.gym.common.core.page.TableDataInfo;

/**
 * 教练评价Controller
 * 
 * @author cqs
 * @date 2026-04-08
 */
@RestController
@RequestMapping("/trainerManagement/evaluation")
public class TrainerEvaluationController extends BaseController
{
    @Autowired
    private ITrainerEvaluationService trainerEvaluationService;

    /**
     * 查询教练评价列表
     */
    @PreAuthorize("@ss.hasPermi('trainerManagement:evaluation:list')")
    @GetMapping("/list")
    public TableDataInfo list(TrainerEvaluation trainerEvaluation)
    {
        startPage();
        List<TrainerEvaluation> list = trainerEvaluationService.selectTrainerEvaluationList(trainerEvaluation);
        return getDataTable(list);
    }

    /**
     * 导出教练评价列表
     */
    @PreAuthorize("@ss.hasPermi('trainerManagement:evaluation:export')")
    @Log(title = "教练评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TrainerEvaluation trainerEvaluation)
    {
        List<TrainerEvaluation> list = trainerEvaluationService.selectTrainerEvaluationList(trainerEvaluation);
        ExcelUtil<TrainerEvaluation> util = new ExcelUtil<TrainerEvaluation>(TrainerEvaluation.class);
        util.exportExcel(response, list, "教练评价数据");
    }

    /**
     * 获取教练评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('trainerManagement:evaluation:query')")
    @GetMapping(value = "/{evaluationId}")
    public AjaxResult getInfo(@PathVariable("evaluationId") Long evaluationId)
    {
        return success(trainerEvaluationService.selectTrainerEvaluationByEvaluationId(evaluationId));
    }

    /**
     * 新增教练评价
     */
    @PreAuthorize("@ss.hasPermi('trainerManagement:evaluation:add')")
    @Log(title = "教练评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TrainerEvaluation trainerEvaluation)
    {
        return toAjax(trainerEvaluationService.insertTrainerEvaluation(trainerEvaluation));
    }

    /**
     * 修改教练评价
     */
    @PreAuthorize("@ss.hasPermi('trainerManagement:evaluation:edit')")
    @Log(title = "教练评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TrainerEvaluation trainerEvaluation)
    {
        return toAjax(trainerEvaluationService.updateTrainerEvaluation(trainerEvaluation));
    }

    /**
     * 删除教练评价
     */
    @PreAuthorize("@ss.hasPermi('trainerManagement:evaluation:remove')")
    @Log(title = "教练评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{evaluationIds}")
    public AjaxResult remove(@PathVariable Long[] evaluationIds)
    {
        return toAjax(trainerEvaluationService.deleteTrainerEvaluationByEvaluationIds(evaluationIds));
    }
}
