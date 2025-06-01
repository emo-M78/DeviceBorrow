package com.ruoyi.device.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.device.domain.DeviceType;
import com.ruoyi.device.service.IDeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*分类控制层*/
@RestController
@RequestMapping("/device/type")
@Anonymous //匿名访问不鉴权注解
public class DeviceTypeController {
    //注入业务层对象
    @Autowired
    private IDeviceTypeService deviceTypeService;

//  新增
    @PostMapping("/add")
//    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResult add(@RequestBody DeviceType deviceType){
        int result = deviceTypeService.insertDeviceType(deviceType);
        return AjaxResult.success("新增成功").put("data",result);
    }

//    修改
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody DeviceType deviceType){
        int result = deviceTypeService.updateDeviceType(deviceType);
        return AjaxResult.success("修改成功").put("data",result);
    }

    /**
     * 分类列表接口：查询所有
     * @return 响应数据
     */
    @GetMapping("/list")
    public AjaxResult list(){
        List<DeviceType> list = deviceTypeService.selectDeviceTypeList();
        return AjaxResult.success("查询成功").put("data",list);
    }

    /**
     * 根据id获取数据
     * @param typeId 分类id
     * @return 响应数据
     */
    @GetMapping("/get")
    public AjaxResult get(Long typeId){
        DeviceType deviceType = deviceTypeService.selectDeviceTypeById(typeId);
        return AjaxResult.success("查询成功").put("data",deviceType);
    }

    /**
     * 根据id删除(逻辑删除)
     * @return
     */
    @GetMapping("/remove")
    public AjaxResult remove(Long typeId){
        int result = deviceTypeService.deleteDeviceTypeById(typeId);
        return AjaxResult.success("删除成功").put("data",result);
    }
}
