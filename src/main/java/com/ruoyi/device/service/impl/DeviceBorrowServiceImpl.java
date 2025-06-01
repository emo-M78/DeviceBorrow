package com.ruoyi.device.service.impl;

import java.beans.Transient;
import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.device.domain.DeviceInfo;
import com.ruoyi.device.mapper.DeviceInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.device.mapper.DeviceBorrowMapper;
import com.ruoyi.device.domain.DeviceBorrow;
import com.ruoyi.device.service.IDeviceBorrowService;

import javax.annotation.Resource;

/**
 * 借用信息Service业务层处理
 * 
 * @author fanjie
 * @date 2025-04-28
 */
@Service
public class DeviceBorrowServiceImpl implements IDeviceBorrowService 
{
    @Autowired
    private DeviceBorrowMapper deviceBorrowMapper;

    /**
     * 查询借用信息
     * 
     * @param borrowId 借用信息主键
     * @return 借用信息
     */
    @Override
    public DeviceBorrow selectDeviceBorrowByBorrowId(Long borrowId)
    {
        return deviceBorrowMapper.selectDeviceBorrowByBorrowId(borrowId);
    }

    /**
     * 查询借用信息列表
     * 
     * @param deviceBorrow 借用信息
     * @return 借用信息
     */
    @Override
    public List<DeviceBorrow> selectDeviceBorrowList(DeviceBorrow deviceBorrow)
    {
        return deviceBorrowMapper.selectDeviceBorrowList(deviceBorrow);
    }

    @Resource
    private DeviceInfoMapper deviceInfoMapper;
    /**
     * 新增借用信息
     * 功能：1、新增借用信息  2、修改设备状态为1（借出）
     * @param deviceBorrow 借用信息
     * @return 结果
     */
    @Override
    public AjaxResult insertDeviceBorrow(DeviceBorrow deviceBorrow)
    {
//        根据设备ID查询设备信息
        DeviceInfo deviceInfo = deviceInfoMapper.selectDeviceInfoByDeviceId(deviceBorrow.getDeviceId());
//        判断设备状态是否存在、设备状态是否为0（正常）
        if (deviceInfo != null && deviceInfo.getDeviceStatus() ==0){
//        修改设备状态为1
            deviceInfo.setDeviceStatus(1);
//        修改状态到数据库
            deviceInfoMapper.updateDeviceInfo(deviceInfo);
//        新增借用信息
            deviceBorrow.setCreateTime(DateUtils.getNowDate());
            deviceBorrowMapper.insertDeviceBorrow(deviceBorrow);
            return AjaxResult.success("借用成功");
        }
        return AjaxResult.warn("借用异常，请联系管理员！");
    }

    /**
     * 修改借用信息
     * 
     * @param deviceBorrow 借用信息
     * @return 结果
     */
    @Override
    @Transient//开始事务：保证多条增删改语句同时执行失败或成功
    public int updateDeviceBorrow(DeviceBorrow deviceBorrow)
    {
//        修改设备状态
        if (deviceBorrow.getDeviceStatus() != null){
//            创建设备对象
            DeviceInfo info = new DeviceInfo();
//            给id赋值
            info.setDeviceId(deviceBorrow.getDeviceId());
//            给设备状态赋值
            info.setDeviceStatus(deviceBorrow.getDeviceStatus());
//            更新设备状态到数据库
            deviceInfoMapper.updateDeviceInfo(info);
        }
        //修改归还状态
        deviceBorrow.setUpdateTime(DateUtils.getNowDate());
        return deviceBorrowMapper.updateDeviceBorrow(deviceBorrow);
    }

    /**
     * 批量删除借用信息
     * 
     * @param borrowIds 需要删除的借用信息主键
     * @return 结果
     */
    @Override
    public int deleteDeviceBorrowByBorrowIds(Long[] borrowIds)
    {
        return deviceBorrowMapper.deleteDeviceBorrowByBorrowIds(borrowIds);
    }

    /**
     * 删除借用信息信息
     * 
     * @param borrowId 借用信息主键
     * @return 结果
     */
    @Override
    public int deleteDeviceBorrowByBorrowId(Long borrowId)
    {
        return deviceBorrowMapper.deleteDeviceBorrowByBorrowId(borrowId);
    }
}
