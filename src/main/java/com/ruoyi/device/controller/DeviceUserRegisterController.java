package com.ruoyi.device.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.device.domain.DeviceInfo;
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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.device.domain.DeviceUserRegister;
import com.ruoyi.device.service.IDeviceUserRegisterService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * app用户注册记录Controller
 * 
 * @author fanjie
 * @date 2025-04-21
 */
@RestController
@RequestMapping("/device/register")
@Anonymous
public class DeviceUserRegisterController extends BaseController
{
    @Autowired
    private IDeviceUserRegisterService deviceUserRegisterService;

    /**
     * 多条件查询小程序用户信息
     * @param deviceUserRegister
     * @return
     */
    @GetMapping("all")
    public AjaxResult all(DeviceUserRegister deviceUserRegister){
//        调用业务层，查询数据
        List<DeviceUserRegister> registers = deviceUserRegisterService.selectDeviceUserRegisterList(deviceUserRegister);
//        响应
        return AjaxResult.success("查询成功",registers);
    }

    /**
     * 查询app用户注册记录列表
     */
    @PreAuthorize("@ss.hasPermi('device:register:list')")//权限验证
    @GetMapping("/list")
    public TableDataInfo list(DeviceUserRegister deviceUserRegister)
    {
        startPage();
        List<DeviceUserRegister> list = deviceUserRegisterService.selectDeviceUserRegisterList(deviceUserRegister);
        return getDataTable(list);
    }

    /**
     * 导出app用户注册记录列表
     */
    @PreAuthorize("@ss.hasPermi('device:register:export')")
    @Log(title = "app用户注册记录", businessType = BusinessType.EXPORT)//日志
    @PostMapping("/export")
    public void export(HttpServletResponse response, DeviceUserRegister deviceUserRegister)
    {
        List<DeviceUserRegister> list = deviceUserRegisterService.selectDeviceUserRegisterList(deviceUserRegister);
        ExcelUtil<DeviceUserRegister> util = new ExcelUtil<DeviceUserRegister>(DeviceUserRegister.class);
        util.exportExcel(response, list, "app用户注册记录数据");
    }

    /**
     * 获取app用户注册记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('device:register:query')")
    @GetMapping(value = "/{regId}")
    public AjaxResult getInfo(@PathVariable("regId") Long regId)
    {
        return success(deviceUserRegisterService.selectDeviceUserRegisterByRegId(regId));
    }

    /**
     * 新增app用户注册记录
     */
    @PreAuthorize("@ss.hasPermi('device:register:add')")
    @Log(title = "app用户注册记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DeviceUserRegister deviceUserRegister)
    {
        return toAjax(deviceUserRegisterService.insertDeviceUserRegister(deviceUserRegister));
    }

    /**
     * 修改app用户注册记录
     */
    @PreAuthorize("@ss.hasPermi('device:register:edit')")
    @Log(title = "app用户注册记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DeviceUserRegister deviceUserRegister)
    {
        return toAjax(deviceUserRegisterService.updateDeviceUserRegister(deviceUserRegister));
    }

    /**
     * 删除app用户注册记录
     */
    @PreAuthorize("@ss.hasPermi('device:register:remove')")
    @Log(title = "app用户注册记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{regIds}")
    public AjaxResult remove(@PathVariable Long[] regIds)
    {
        return toAjax(deviceUserRegisterService.deleteDeviceUserRegisterByRegIds(regIds));
    }
}
