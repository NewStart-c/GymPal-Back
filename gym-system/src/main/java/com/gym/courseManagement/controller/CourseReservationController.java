package com.gym.courseManagement.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.gym.common.core.domain.model.LoginUser;
import com.gym.common.utils.DateUtils;
import com.gym.common.utils.SecurityUtils;
import com.gym.memberManagement.domain.Member;
import com.gym.memberManagement.service.IMemberService;
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
import com.gym.courseManagement.domain.CourseReservation;
import com.gym.courseManagement.service.ICourseReservationService;
import com.gym.common.utils.poi.ExcelUtil;
import com.gym.common.core.page.TableDataInfo;

/**
 * 课程预约Controller
 * 
 * @author cqs
 * @date 2026-04-08
 */
@RestController
@RequestMapping("/courseManagement/courseReservation")
public class CourseReservationController extends BaseController
{
    @Autowired
    private ICourseReservationService courseReservationService;

    @Autowired
    private IMemberService memberService;

    /**
     * 会员-通过会员ID查询
     */
    @GetMapping("/myList")
    public AjaxResult myList() {
        CourseReservation courseReservation = new CourseReservation();
        LoginUser loginUser = getLoginUser();
        String number = loginUser.getPhonenumber();
        Member member = memberService.selectMemberByNumber(number);
        Long memberId = member.getMemberId();
        courseReservation.setMemberId(memberId);
        //courseReservation.setDelFlag("0");
        List<CourseReservation> list = courseReservationService.selectCourseReservationList(courseReservation);

        System.out.println("id是多少：" + memberId + "\n返回了什么:" + list);
        return AjaxResult.success(list);
    }


    /**
     * 会员-提交预约
     */
    @PostMapping("/memberReserve")
    public AjaxResult memberReserve(@RequestBody CourseReservation courseReservation) {
        LoginUser loginUser = getLoginUser();
        String number = loginUser.getPhonenumber();
        Member member = memberService.selectMemberByNumber(number);
        Long memberId = member.getMemberId();

        courseReservation.setMemberId(memberId);
        courseReservation.setStatus("0"); // 0=已预约
        courseReservation.setReservationTime(DateUtils.getNowDate());
        return toAjax(courseReservationService.insertCourseReservation(courseReservation));
    }

    /**
     * 会员-签到
     */
    @PostMapping("/sign/{reservationId}")
    public AjaxResult sign(@PathVariable("reservationId") Long reservationId) {
        CourseReservation reservation = courseReservationService.selectCourseReservationByReservationId(reservationId);
        if (!"0".equals(reservation.getStatus())) {
            return AjaxResult.error("只能签到待预约状态");
        }
        reservation.setStatus("1");
        return toAjax(courseReservationService.updateCourseReservation(reservation));
    }

    /**
     * 会员-消课
     */
    @PostMapping("/finish/{reservationId}")
    public AjaxResult finish(@PathVariable("reservationId") Long reservationId) {
        CourseReservation reservation = courseReservationService.selectCourseReservationByReservationId(reservationId);
        if (!"1".equals(reservation.getStatus())) {
            return AjaxResult.error("只能消课已签到状态");
        }
        reservation.setStatus("2");
        return toAjax(courseReservationService.updateCourseReservation(reservation));
    }

    /**
     * 会员-取消预约
     */
    @PostMapping("/cancel/{reservationId}")
    public AjaxResult cancel(@PathVariable("reservationId") Long reservationId) {
        CourseReservation reservation = courseReservationService.selectCourseReservationByReservationId(reservationId);
        reservation.setStatus("3");
        return toAjax(courseReservationService.updateCourseReservation(reservation));
    }

    /**
     * 查询课程预约列表
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseReservation:list')")
    @GetMapping("/list")
    public TableDataInfo list(CourseReservation courseReservation)
    {
        startPage();
        List<CourseReservation> list = courseReservationService.selectCourseReservationList(courseReservation);
        return getDataTable(list);
    }

    /**
     * 导出课程预约列表
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseReservation:export')")
    @Log(title = "课程预约", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CourseReservation courseReservation)
    {
        List<CourseReservation> list = courseReservationService.selectCourseReservationList(courseReservation);
        ExcelUtil<CourseReservation> util = new ExcelUtil<CourseReservation>(CourseReservation.class);
        util.exportExcel(response, list, "课程预约数据");
    }

    /**
     * 获取课程预约详细信息
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseReservation:query')")
    @GetMapping(value = "/{reservationId}")
    public AjaxResult getInfo(@PathVariable("reservationId") Long reservationId)
    {
        return success(courseReservationService.selectCourseReservationByReservationId(reservationId));
    }

    /**
     * 新增课程预约
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseReservation:add')")
    @Log(title = "课程预约", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CourseReservation courseReservation)
    {
        //courseReservation.getCourseId();
        return toAjax(courseReservationService.insertCourseReservation(courseReservation));
    }

    /**
     * 修改课程预约
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseReservation:edit')")
    @Log(title = "课程预约", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CourseReservation courseReservation)
    {
        return toAjax(courseReservationService.updateCourseReservation(courseReservation));
    }

    /**
     * 删除课程预约
     */
    @PreAuthorize("@ss.hasPermi('courseManagement:courseReservation:remove')")
    @Log(title = "课程预约", businessType = BusinessType.DELETE)
	@DeleteMapping("/{reservationIds}")
    public AjaxResult remove(@PathVariable Long[] reservationIds)
    {
        return toAjax(courseReservationService.deleteCourseReservationByReservationIds(reservationIds));
    }
}
