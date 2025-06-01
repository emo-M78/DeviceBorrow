package com.ruoyi.device.mapper;

import com.ruoyi.device.domain.DeviceType;

import java.util.List;

public interface DeviceTypeMapper {
    /*增设备分类
    *@param deviceType设备分类
    *@return影响的行数
     */
    public int insertDeviceType(DeviceType deviceType);

    /*修改设备分类
    @param deviceType
     */
    public int updateDeviceType(DeviceType deviceType);

    /**
     * 查询分类列表
     * List<DeviceType>:集合，存储多个对象，存储是DeviceType对象
     * @return
     */
    public List<DeviceType> selectDeviceTypeList();

    /**
     * 根据id查询分类信息
     * @param typeId 分类主键
     * @return
     */
    public DeviceType selectDeviceTypeById(Long typeId);

    /**
     * 根据id删除
     * 类型状态：-1删除 0 正常 1禁用
     *
     * @param typeId
     * @return
     */
    public int deleteDeviceTypeById(Long typeId);
}
