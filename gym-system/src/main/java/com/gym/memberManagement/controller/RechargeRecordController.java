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
import com.gym.memberManagement.domain.RechargeRecord;
import com.gym.memberManagement.service.IRechargeRecordService;
import com.gym.common.utils.poi.ExcelUtil;
import com.gym.common.core.page.TableDataInfo;

/**
 * 储值记录Controller
 * 
 * @author cqs
 * @date 2026-04-08
 */
@RestController
@RequestMapping("/memberManagement/rechargeRecord")
public class RechargeRecordController extends BaseController
{
    @Autowired
    private IRechargeRecordService rechargeRecordService;

    /**
     * 查询储值记录列表
     */
    @PreAuthorize("@ss.hasPermi('memberManagement:rechargeRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(RechargeRecord rechargeRecord)
    {
        startPage();
        List<RechargeRecord> list = rechargeRecordService.selectRechargeRecordList(rechargeRecord);
        return getDataTable(list);
    }

    /**
     * 导出储值记录列表
     */
    @PreAuthorize("@ss.hasPermi('memberManagement:rechargeRecord:export')")
    @Log(title = "储值记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RechargeRecord rechargeRecord)
    {
        List<RechargeRecord> list = rechargeRecordService.selectRechargeRecordList(rechargeRecord);
        ExcelUtil<RechargeRecord> util = new ExcelUtil<RechargeRecord>(RechargeRecord.class);
        util.exportExcel(response, list, "储值记录数据");
    }

    /**
     * 获取储值记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('memberManagement:rechargeRecord:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(rechargeRecordService.selectRechargeRecordByRecordId(recordId));
    }

    /**
     * 新增储值记录
     */
    @PreAuthorize("@ss.hasPermi('memberManagement:rechargeRecord:add')")
    @Log(title = "储值记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RechargeRecord rechargeRecord)
    {
        return toAjax(rechargeRecordService.insertRechargeRecord(rechargeRecord));
    }

    /**
     * 修改储值记录
     */
    @PreAuthorize("@ss.hasPermi('memberManagement:rechargeRecord:edit')")
    @Log(title = "储值记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RechargeRecord rechargeRecord)
    {
        return toAjax(rechargeRecordService.updateRechargeRecord(rechargeRecord));
    }

    /**
     * 删除储值记录
     */
    @PreAuthorize("@ss.hasPermi('memberManagement:rechargeRecord:remove')")
    @Log(title = "储值记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(rechargeRecordService.deleteRechargeRecordByRecordIds(recordIds));
    }
}
