package com.gym.memberManagement.controller;

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
import com.gym.memberManagement.domain.MemberLevel;
import com.gym.memberManagement.service.IMemberLevelService;
import com.gym.common.utils.poi.ExcelUtil;
import com.gym.common.core.page.TableDataInfo;

/**
 * 会员等级Controller
 * 
 * @author cqs
 * @date 2026-04-08
 */
@RestController
@RequestMapping("/memberManagement/mamberLevel")
public class MemberLevelController extends BaseController
{
    @Autowired
    private IMemberLevelService memberLevelService;

    /**
     * 查询会员等级列表
     */
    @PreAuthorize("@ss.hasPermi('memberManagement:mamberLevel:list')")
    @GetMapping("/list")
    public TableDataInfo list(MemberLevel memberLevel)
    {
        startPage();
        List<MemberLevel> list = memberLevelService.selectMemberLevelList(memberLevel);
        return getDataTable(list);
    }

    /**
     * 导出会员等级列表
     */
    @PreAuthorize("@ss.hasPermi('memberManagement:mamberLevel:export')")
    @Log(title = "会员等级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberLevel memberLevel)
    {
        List<MemberLevel> list = memberLevelService.selectMemberLevelList(memberLevel);
        ExcelUtil<MemberLevel> util = new ExcelUtil<MemberLevel>(MemberLevel.class);
        util.exportExcel(response, list, "会员等级数据");
    }

    /**
     * 获取会员等级详细信息
     */
    @PreAuthorize("@ss.hasPermi('memberManagement:mamberLevel:query')")
    @GetMapping(value = "/{levelId}")
    public AjaxResult getInfo(@PathVariable("levelId") Long levelId)
    {
        return success(memberLevelService.selectMemberLevelByLevelId(levelId));
    }

    /**
     * 新增会员等级
     */
    @PreAuthorize("@ss.hasPermi('memberManagement:mamberLevel:add')")
    @Log(title = "会员等级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberLevel memberLevel)
    {
        return toAjax(memberLevelService.insertMemberLevel(memberLevel));
    }

    /**
     * 修改会员等级
     */
    @PreAuthorize("@ss.hasPermi('memberManagement:mamberLevel:edit')")
    @Log(title = "会员等级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberLevel memberLevel)
    {
        return toAjax(memberLevelService.updateMemberLevel(memberLevel));
    }

    /**
     * 删除会员等级
     */
    @PreAuthorize("@ss.hasPermi('memberManagement:mamberLevel:remove')")
    @Log(title = "会员等级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{levelIds}")
    public AjaxResult remove(@PathVariable Long[] levelIds)
    {
        return toAjax(memberLevelService.deleteMemberLevelByLevelIds(levelIds));
    }
}
