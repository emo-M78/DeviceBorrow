package com.ruoyi.device.service;

import com.ruoyi.device.domain.DeviceType;

import java.util.List;

/*业务层接口*/
public interface IDeviceTypeService {
    /**
     *
    新增设备分类
     */
    public int insertDeviceType(DeviceType deviceType);
    /**
   修改设备分类
    */
    public int updateDeviceType(DeviceType deviceType);

    /**
     * 查询设备分类的列表
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
     * 删除分类
     * @param typeId 分类id
     * @return 行数
     */
    public int deleteDeviceTypeById(Long typeId);
}
