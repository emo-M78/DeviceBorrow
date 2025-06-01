package com.ruoyi.device.service.impl;

import com.ruoyi.device.domain.DeviceType;
import com.ruoyi.device.mapper.DeviceTypeMapper;
import com.ruoyi.device.service.IDeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DeviceTypeServiceImpl implements IDeviceTypeService {
    //注入数据层
    @Resource
    private DeviceTypeMapper deviceTypeMapper;

    /*新增*/
    @Override
    public int insertDeviceType(DeviceType deviceType) {
        deviceType.setCreateTime(new Date());
        return deviceTypeMapper.insertDeviceType(deviceType);
    }

//    修改
    @Override
    public int updateDeviceType(DeviceType deviceType) {
        //给修改时间赋值
        deviceType.setUpdateTime(new Date());
        //调用数据访问层的修改方法，实现数据的修改
        return deviceTypeMapper.updateDeviceType(deviceType);
    }

//    设备查询
    @Override
    public List<DeviceType> selectDeviceTypeList() {
//         调用数据访问层，获取数据
        return deviceTypeMapper.selectDeviceTypeList();
    }
//    根据ID查询设备
    @Override
    public DeviceType selectDeviceTypeById(Long typeId) {
        //调取数据访问层，获取数据
        return deviceTypeMapper.selectDeviceTypeById(typeId);
    }

//    删除设备
    @Override
    public int deleteDeviceTypeById(Long typeId) {
        //调取数据访问层，删除数据
        return deviceTypeMapper.deleteDeviceTypeById(typeId);
    }
}
