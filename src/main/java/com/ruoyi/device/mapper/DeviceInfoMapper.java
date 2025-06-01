package com.ruoyi.device.mapper;

import com.ruoyi.device.domain.DeviceInfo;

import java.util.List;

/**
 * 数据访问层接口
 */
public interface DeviceInfoMapper {
    /**
     * 新增设备信息
     * @param deviceInfo
     * @return
     */
    public int insertDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 修改设备信息
     * @param deviceInfo
     * @return
     */
    public int updateDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 多条件查询设备信息
     * @param deviceInfo
     * @return
     */
    public List<DeviceInfo> selectDeviceInfoList(DeviceInfo deviceInfo);

    /**
     *根据id查询
     * @param deviceId
     * @return
     */
    public DeviceInfo selectDeviceInfoByDeviceId(Long deviceId);

    /**
     * 根据id删除设备
     * @param deviceId
     * @return
     */
    public int deleteDeviceInfoById(Long deviceId);


}
