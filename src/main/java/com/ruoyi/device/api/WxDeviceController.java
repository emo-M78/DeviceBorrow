package com.ruoyi.device.api;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.device.domain.DeviceBorrow;
import com.ruoyi.device.domain.DeviceInfo;
import com.ruoyi.device.domain.DeviceType;
import com.ruoyi.device.service.IDeviceBorrowService;
import com.ruoyi.device.service.IDeviceInfoService;
import com.ruoyi.device.service.IDeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.Date;
import java.util.List;

@RestController//标记控制器
@Anonymous//匿名访问
@RequestMapping("/wechart/device")//访问路径
public class WxDeviceController {
    //注入设备的业务层
    @Autowired
    private IDeviceTypeService deviceTypeService;

    /**
     * 获取设备类型列表接口
     * 请求方法：get ，路径：http://localhost:8080/wechart/device/typeList
     * @return
     */
    @GetMapping("typeList")
    public AjaxResult typeList(){
        List<DeviceType> list = deviceTypeService.selectDeviceTypeList();
        return AjaxResult.success("查询成功",list);
    }

    //注入设备列表业务层
    @Autowired
    private IDeviceInfoService deviceInfoService;

    /**
     * 获取设备列表的接口
     * 请求方法：get ，路径：http://localhost:8080/wechart/device/deviceList
     * @param typeId
     * @param deviceName
     * @param deviceStatus
     * @return
     */
    @GetMapping("deviceList")
    public AjaxResult deviceList(Long typeId,String deviceName,Integer deviceStatus){
        //创建设备对象
        DeviceInfo info = new DeviceInfo();
        //数据封装
        if (typeId != null){
            info.setTypeId(typeId);
        }
        if (StringUtils.isNotBlank(deviceName)){
            info.setDeviceName(deviceName);
        }
        if (deviceStatus != null){
            info.setDeviceStatus(deviceStatus);
        }
        //调用业务层查询方法，获取数据
        List<DeviceInfo> list = deviceInfoService.selectDeviceInfoList(info);
        return AjaxResult.success("查询成功",list);
    }

    /**
     * 获取设备详情接口
     * 请求方法：get ，路径：http://localhost:8080/wechart/device/deviceInfo
     * @param deviceId
     * @return
     */
    @GetMapping("deviceInfo")
    public AjaxResult deviceInfo(Long deviceId){
        DeviceInfo info = deviceInfoService.selectDeviceInfoByDeviceId(deviceId);
        return AjaxResult.success("查询成功",info);
    }

    //注入设备借用业务层对象
    @Autowired
    private IDeviceBorrowService deviceBorrowService;

    /**
     * 借用列表接口
     * @param returnStatus 归还状态
     * @param userId 小程序用户id
     * @return
     */
    @GetMapping("borrowList")
    public AjaxResult borrowList(Integer returnStatus,Long userId) {
        //封装数据到对象
        DeviceBorrow deviceBorrow = new DeviceBorrow();
        if (returnStatus != null) {
            deviceBorrow.setReturnStatus(returnStatus);
        }
        if (userId != null) {
            deviceBorrow.setUserId(userId);
        }
        //调用业务层获取数据
        List<DeviceBorrow> list = deviceBorrowService.selectDeviceBorrowList(deviceBorrow);
        //响应
        return AjaxResult.success("查询成功", list);
    }

    /**
     * 借用设备（小程序申请借用）接口
     * @param deviceBorrow
     * @return
     */
    @PostMapping("borrowDevice")
    public AjaxResult borrowDevice(@RequestBody DeviceBorrow deviceBorrow){
        //借用时间：当前系统时间
        deviceBorrow.setBorrowTime(new Date());
        //设置归还状态
        deviceBorrow.setReturnStatus(0);
        //直接调用业务层方法,实现设备借用
        return deviceBorrowService.insertDeviceBorrow(deviceBorrow);
    }

    /**
     * 设备归还（小程序用户申请归还）接口
     * @param deviceBorrow
     * @return
     */
    @PostMapping("returnBorrow")
    public AjaxResult returnBorrow(@RequestBody DeviceBorrow deviceBorrow){
        //设置归还状态
        deviceBorrow.setReturnStatus(2);
        //调用业务层修改方法，跟新归还状态
        int result = deviceBorrowService.updateDeviceBorrow(deviceBorrow);
        return AjaxResult.success("申请成功",result);
    }
}

