package com.gym.courseManagement.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.gym.common.utils.DateUtils;
import com.gym.common.utils.SecurityUtils;
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
import com.gym.courseManagement.domain.CourseEvaluation;
import com.gym.courseManagement.service.ICourseEvaluationService;
import com.gym.common.utils.poi.ExcelUtil;
import com.gym.common.core.page.TableDataInfo;

/**
 * 课程评价Controller
 * 
 * @author cqs
 * @date 2026-04-12
 */
@RestController
@RequestMapping("/courseManagement/courseEvaluation")
public class CourseEvaluationController extends BaseController
{
    @Autowired
    private ICourseEvaluationService courseEvaluationService;

    /**
     * 会员-提交评价
     */
    @PostMapping("/memberEvaluate")
    public AjaxResult memberEvaluate(@RequestBody CourseEvaluation courseEvaluation) {
        // Long userId = SecurityUtils.getLoginUser().getUserId();
        // courseEvaluation.setMemberId(memberId);
        courseEvaluation.setEvaluationTime(DateUtils.getNowDate());
        return toAjax(courseEvaluationService.insertCourseEvaluation(courseEvaluation));
    }

    /**
     * 查询课程评价列表
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseEvaluation:list')")
    @GetMapping("/list")
    public TableDataInfo list(CourseEvaluation courseEvaluation)
    {
        startPage();
        List<CourseEvaluation> list = courseEvaluationService.selectCourseEvaluationList(courseEvaluation);
        return getDataTable(list);
    }

    /**
     * 导出课程评价列表
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseEvaluation:export')")
    @Log(title = "课程评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CourseEvaluation courseEvaluation)
    {
        List<CourseEvaluation> list = courseEvaluationService.selectCourseEvaluationList(courseEvaluation);
        ExcelUtil<CourseEvaluation> util = new ExcelUtil<CourseEvaluation>(CourseEvaluation.class);
        util.exportExcel(response, list, "课程评价数据");
    }

    /**
     * 获取课程评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseEvaluation:query')")
    @GetMapping(value = "/{evaluationId}")
    public AjaxResult getInfo(@PathVariable("evaluationId") Long evaluationId)
    {
        return success(courseEvaluationService.selectCourseEvaluationByEvaluationId(evaluationId));
    }

    /**
     * 新增课程评价
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseEvaluation:add')")
    @Log(title = "课程评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CourseEvaluation courseEvaluation)
    {
        return toAjax(courseEvaluationService.insertCourseEvaluation(courseEvaluation));
    }

    /**
     * 修改课程评价
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseEvaluation:edit')")
    @Log(title = "课程评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CourseEvaluation courseEvaluation)
    {
        return toAjax(courseEvaluationService.updateCourseEvaluation(courseEvaluation));
    }

    /**
     * 删除课程评价
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseEvaluation:remove')")
    @Log(title = "课程评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{evaluationIds}")
    public AjaxResult remove(@PathVariable Long[] evaluationIds)
    {
        return toAjax(courseEvaluationService.deleteCourseEvaluationByEvaluationIds(evaluationIds));
    }
}
