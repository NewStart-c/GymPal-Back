package com.gym.coach.controller;

import com.gym.common.core.controller.BaseController;
import com.gym.common.core.domain.AjaxResult;
import com.gym.common.core.domain.model.LoginUser;
import com.gym.common.core.page.TableDataInfo;
import com.gym.courseManagement.domain.Course;
import com.gym.courseManagement.domain.CourseReservation;
import com.gym.courseManagement.service.ICourseOrderService;
import com.gym.courseManagement.service.ICourseReservationService;
import com.gym.courseManagement.service.ICourseService;
import com.gym.trainerManagement.domain.Trainer;
import com.gym.trainerManagement.domain.TrainerEvaluation;
import com.gym.trainerManagement.service.ITrainerEvaluationService;
import com.gym.trainerManagement.service.ITrainerService;
import com.gym.empManagement.domain.EmpSchedule;
import com.gym.empManagement.service.IEmpScheduleService;
import com.gym.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 教练端统一接口
 * 权限：所有登录教练均可访问
 */
@RestController
@RequestMapping("/coach")
public class CoachController extends BaseController {

    @Autowired
    private ITrainerService trainerService;

    @Autowired
    private ICourseService courseService;

    @Autowired
    private ICourseReservationService courseReservationService;

    @Autowired
    private ITrainerEvaluationService trainerEvaluationService;

    @Autowired
    private IEmpScheduleService empScheduleService;

    @Autowired
    private ICourseOrderService courseOrderService;


    // ====================== 教练ID获取 ======================
    @GetMapping("/trainerID")
    @PreAuthorize("isAuthenticated()")
    public AjaxResult getLoginTrainerIdFront() {
        //String username = SecurityUtils.getUsername();
        LoginUser loginUser = getLoginUser();
        Long employeeId = loginUser.getUserId();
        Trainer t = trainerService.selectTrainerByEmployeeId(employeeId);
        System.out.println("前端获取id了吗？:" + t.getTrainerId());

        return AjaxResult.success(t);
    }

    private Long getLoginTrainerId() {
        //String username = SecurityUtils.getUsername();
        LoginUser loginUser = getLoginUser();
        Long employeeId = loginUser.getUserId();
        Trainer t = trainerService.selectTrainerByEmployeeId(employeeId);
        return t.getTrainerId();
    }

    // ====================== 1. 个人资料 ======================
    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public AjaxResult getProfile() {
        Trainer trainer = trainerService.selectTrainerByTrainerId(getLoginTrainerId());
        System.out.println("这里有东西吗？:" + trainer + "能拿到教练id吗:" + getLoginTrainerId());
        return AjaxResult.success(trainer);
    }

    @PutMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public AjaxResult updateProfile(@RequestBody Trainer trainer) {
        trainer.setTrainerId(getLoginTrainerId());
        return toAjax(trainerService.updateTrainer(trainer));
    }

    // ====================== 2. 我的排班 ======================
    @GetMapping("/schedule")
    @PreAuthorize("isAuthenticated()")
    public TableDataInfo schedule(EmpSchedule empSchedule) {
        startPage();
        empSchedule.setUserId(SecurityUtils.getUserId());
        List<EmpSchedule> list = empScheduleService.selectEmpScheduleList(empSchedule);
        return getDataTable(list);
    }

    // ====================== 3. 我的课程 ======================
    @GetMapping("/course")
    @PreAuthorize("isAuthenticated()")
    public TableDataInfo courseList(Course course) {
        startPage();
        course.setTrainerId(getLoginTrainerId());
        List<Course> list = courseService.selectCourseList(course);
        return getDataTable(list);
    }

    // ====================== 4. 我的学员预约 ======================
    @GetMapping("/reservation")
    @PreAuthorize("isAuthenticated()")
    public TableDataInfo reservationList(CourseReservation reservation) {
        startPage();
        reservation.setTrainerId(getLoginTrainerId());
        List<CourseReservation> list = courseReservationService.selectCourseReservationList(reservation);
        return getDataTable(list);
    }

    // ====================== 5. 学员签到 ======================
    @PutMapping("/sign/{reservationId}")
    @PreAuthorize("isAuthenticated()")
    public AjaxResult sign(@PathVariable Long reservationId) {
        CourseReservation r = new CourseReservation();
        r.setReservationId(reservationId);
        r.setStatus("1"); // 1=已签到
        return toAjax(courseReservationService.updateCourseReservation(r));
    }

    // ====================== 6. 我的评价 ======================
    @GetMapping("/evaluation")
    @PreAuthorize("isAuthenticated()")
    public TableDataInfo evaluation(TrainerEvaluation e) {
        startPage();
        e.setTrainerId(getLoginTrainerId());
        List<TrainerEvaluation> list = trainerEvaluationService.selectTrainerEvaluationList(e);
        return getDataTable(list);
    }

    // ====================== 7. 工作台统计 ======================
    @GetMapping("/dashboard")
    @PreAuthorize("isAuthenticated()")
    public AjaxResult dashboard() {
        Long tid = getLoginTrainerId();
        Long courseCount = courseService.countCourseByTrainerId(tid);
        Long reservationCount = courseReservationService.countReservationByTrainerId(tid);
        System.out.println("教练ID是否返回：" + tid + "课程数量：" + courseCount + "预约数量:" + reservationCount);
        double scoreAvg = trainerEvaluationService.getAvgScoreByTrainerId(tid);
        double money = courseOrderService.getMoneyByTrainerId(tid);

        List<Integer> reservation7Days = courseReservationService.getReservationLast7Days(tid);
        //List<Map<String, Object>> courseTypeData = courseService.getCourseTypeCount(tid);

        Map<String, Object> map = new HashMap<>();
        map.put("courseCount", courseCount);
        map.put("reservationCount", reservationCount);
        map.put("scoreAvg", scoreAvg);
        map.put("money", money);

        // 图表数据
        map.put("reservation7Days", reservation7Days);
        //map.put("courseTypeData", courseTypeData);

        return AjaxResult.success(map);
    }


}