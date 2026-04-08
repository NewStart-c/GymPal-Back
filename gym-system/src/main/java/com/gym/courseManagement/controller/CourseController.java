package com.gym.courseManagement.controller;

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
import com.gym.courseManagement.domain.Course;
import com.gym.courseManagement.service.ICourseService;
import com.gym.common.utils.poi.ExcelUtil;
import com.gym.common.core.page.TableDataInfo;

/**
 * 课程信息Controller
 * 
 * @author cqs
 * @date 2026-04-08
 */
@RestController
@RequestMapping("/courseManagement/course")
public class CourseController extends BaseController
{
    @Autowired
    private ICourseService courseService;

    /**
     * 查询课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(Course course)
    {
        startPage();
        List<Course> list = courseService.selectCourseList(course);
        return getDataTable(list);
    }

    /**
     * 导出课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:course:export')")
    @Log(title = "课程信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Course course)
    {
        List<Course> list = courseService.selectCourseList(course);
        ExcelUtil<Course> util = new ExcelUtil<Course>(Course.class);
        util.exportExcel(response, list, "课程信息数据");
    }

    /**
     * 获取课程信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:course:query')")
    @GetMapping(value = "/{courseId}")
    public AjaxResult getInfo(@PathVariable("courseId") Long courseId)
    {
        return success(courseService.selectCourseByCourseId(courseId));
    }

    /**
     * 新增课程信息
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:course:add')")
    @Log(title = "课程信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Course course)
    {
        return toAjax(courseService.insertCourse(course));
    }

    /**
     * 修改课程信息
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:course:edit')")
    @Log(title = "课程信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Course course)
    {
        return toAjax(courseService.updateCourse(course));
    }

    /**
     * 删除课程信息
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:course:remove')")
    @Log(title = "课程信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{courseIds}")
    public AjaxResult remove(@PathVariable Long[] courseIds)
    {
        return toAjax(courseService.deleteCourseByCourseIds(courseIds));
    }
}
