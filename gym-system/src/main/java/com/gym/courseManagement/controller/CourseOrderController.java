package com.gym.courseManagement.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

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
import com.gym.courseManagement.domain.CourseOrder;
import com.gym.courseManagement.service.ICourseOrderService;
import com.gym.common.utils.poi.ExcelUtil;
import com.gym.common.core.page.TableDataInfo;

/**
 * 课程订单Controller
 * 
 * @author cqs
 * @date 2026-04-12
 */
@RestController
@RequestMapping("/courseManagement/courseOrder")
public class CourseOrderController extends BaseController
{
    @Autowired
    private ICourseOrderService courseOrderService;

    /**
     * 会员-课程支付
     */
    @PostMapping("/memberPay")
    public AjaxResult memberPay(@RequestBody CourseOrder courseOrder) {
        Long memberId = SecurityUtils.getLoginUser().getUserId();
        courseOrder.setMemberId(memberId);
        courseOrder.setStatus("1"); // 已支付
        return toAjax(courseOrderService.insertCourseOrder(courseOrder));
    }

    /**
     * 查询课程订单列表
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(CourseOrder courseOrder)
    {
        startPage();
        List<CourseOrder> list = courseOrderService.selectCourseOrderList(courseOrder);
        return getDataTable(list);
    }

    /**
     * 导出课程订单列表
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseOrder:export')")
    @Log(title = "课程订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CourseOrder courseOrder)
    {
        List<CourseOrder> list = courseOrderService.selectCourseOrderList(courseOrder);
        ExcelUtil<CourseOrder> util = new ExcelUtil<CourseOrder>(CourseOrder.class);
        util.exportExcel(response, list, "课程订单数据");
    }

    /**
     * 获取课程订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseOrder:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return success(courseOrderService.selectCourseOrderByOrderId(orderId));
    }

    /**
     * 新增课程订单
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseOrder:add')")
    @Log(title = "课程订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CourseOrder courseOrder)
    {
        return toAjax(courseOrderService.insertCourseOrder(courseOrder));
    }

    /**
     * 修改课程订单
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseOrder:edit')")
    @Log(title = "课程订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CourseOrder courseOrder)
    {
        return toAjax(courseOrderService.updateCourseOrder(courseOrder));
    }

    /**
     * 删除课程订单
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseOrder:remove')")
    @Log(title = "课程订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(courseOrderService.deleteCourseOrderByOrderIds(orderIds));
    }
}
