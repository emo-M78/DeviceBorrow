package com.ruoyi.device.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.device.domain.DeviceInfo;

import java.util.List;

/**
 * 业务层接口
 */
public interface IDeviceInfoService {
    /**
     * 新增信息
     * @param deviceInfo
     * @return
     */
    public int insertDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 修改信息
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
    public AjaxResult deleteDeviceInfoById(Long deviceId);
}
