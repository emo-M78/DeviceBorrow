package com.ruoyi.device.service.impl;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.device.domain.DeviceInfo;
import com.ruoyi.device.mapper.DeviceInfoMapper;
import com.ruoyi.device.service.IDeviceInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 实现层
 */

@Service
public class DeviceInfoServiceImpl implements IDeviceInfoService {
    @Resource
    private DeviceInfoMapper deviceInfoMapper;
    @Override
    public int insertDeviceInfo(DeviceInfo deviceInfo) {
        int result = deviceInfoMapper.insertDeviceInfo(deviceInfo);
        System.out.println("新增主键"+deviceInfo.getDeviceId());
        return result;
    }

    @Override
    public int updateDeviceInfo(DeviceInfo deviceInfo) {
        //给修改时间赋值
        deviceInfo.setUpdateTime(new Date());
        //调用数据访问层的修改方法，实现数据修改
        return deviceInfoMapper.updateDeviceInfo(deviceInfo);
    }

    @Override
    public List<DeviceInfo> selectDeviceInfoList(DeviceInfo deviceInfo) {
        //调用数据访问层，获取数据
        return deviceInfoMapper.selectDeviceInfoList(deviceInfo);
    }

    @Override
    public DeviceInfo selectDeviceInfoByDeviceId(Long deviceId) {
        //调用数据访问层，获取数据
        return deviceInfoMapper.selectDeviceInfoByDeviceId(deviceId);
    }

    @Override
    public AjaxResult deleteDeviceInfoById(Long deviceId) {
        //查询删除设备
        DeviceInfo deviceInfo = deviceInfoMapper.selectDeviceInfoByDeviceId(deviceId);
        if (deviceInfo.getDeviceStatus() == 1){
            return AjaxResult.warn("删除失败，该设备已借出");
        }else {
            //调用数据层删除数据
            int result = deviceInfoMapper.deleteDeviceInfoById(deviceId);
            //删除为1时，成功，否则失败
            return result==1?AjaxResult.success("删除成功"):AjaxResult.success();
        }
    }
}
