package com.ruoyi.device.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.device.domain.DeviceInfo;
import com.ruoyi.device.service.IDeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 控制层
 */
@RestController //标记为控制器
@RequestMapping("/device/info")  //访问路径
@Anonymous //支持匿名访问
public class DeviceInfoController extends BaseController {
    @Autowired
    private IDeviceInfoService deviceInfoService;

    /**
     * 多条件查询设备信息
     * @param deviceInfo
     * @return
     */
    @GetMapping("all")
    public AjaxResult all(DeviceInfo deviceInfo){
//        调用业务层，查询数据
        List<DeviceInfo> infoList = deviceInfoService.selectDeviceInfoList(deviceInfo);
//        响应
        return AjaxResult.success("查询成功",infoList);
    }


    /**
     * 新增设备信息接口
     * @param deviceInfo
     * @return
     */
    @RequestMapping
    public AjaxResult add(@RequestBody DeviceInfo deviceInfo){
        //调用业务层处理数据
        int result = deviceInfoService.insertDeviceInfo(deviceInfo);
        //响应
        return success("新增成功").put("data",result);
    }

    /**
     * 修改信息接口
     * @param deviceInfo
     * @return
     */
    @PutMapping
    public AjaxResult edit(@RequestBody DeviceInfo deviceInfo){
        int result = deviceInfoService.updateDeviceInfo(deviceInfo);
        return success("修改成功").put("data",result);
    }

    /**
     * 多条件分页查询
     * @param deviceInfo
     * @return
     */
    @GetMapping("/list")
    public TableDataInfo list(DeviceInfo deviceInfo){
        startPage();//开启分页
        //若依进行分页查询
        List<DeviceInfo> deviceInfos = deviceInfoService.selectDeviceInfoList(deviceInfo);
        return getDataTable(deviceInfos);
    }

    /**
     *根据id查询
     * 请求方法Get，@PathVariable（“deviceId”）获取请求路径上的数据
     * @param deviceId
     * @return
     */
    @GetMapping("{deviceId}")
    public AjaxResult get(@PathVariable("deviceId") Long deviceId){
        //调用业务成
        DeviceInfo deviceInfo = deviceInfoService.selectDeviceInfoByDeviceId(deviceId);
        return success("查询成功").put("data",deviceInfo);
    }

//    根据ID删除
    @DeleteMapping("{deviceId}")
    public AjaxResult remove(@PathVariable("deviceId") Long deviceId){
        //调用业务成处理数据
        return deviceInfoService.deleteDeviceInfoById(deviceId);
    }

//导出
    @PostMapping("/export")
    public void export(HttpServletResponse response,DeviceInfo deviceInfo){
        List<DeviceInfo> deviceInfos = deviceInfoService.selectDeviceInfoList(deviceInfo);
        //创建工具类
        ExcelUtil<DeviceInfo> util = new ExcelUtil<>(DeviceInfo.class);
        //调用该工具类方法，实现导出
        util.exportExcel(response,deviceInfos,"设备信息-1","设备信息-2");
    }
}
