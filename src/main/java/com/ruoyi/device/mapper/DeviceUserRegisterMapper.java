package com.ruoyi.device.mapper;

import java.util.List;
import com.ruoyi.device.domain.DeviceUserRegister;

/**
 * app用户注册记录Mapper接口
 * 
 * @author fanjie
 * @date 2025-04-21
 */
public interface DeviceUserRegisterMapper 
{
    /**
     * 查询app用户注册记录
     * 
     * @param regId app用户注册记录主键
     * @return app用户注册记录
     */
    public DeviceUserRegister selectDeviceUserRegisterByRegId(Long regId);

    /**
     * 查询app用户注册记录列表
     * 
     * @param deviceUserRegister app用户注册记录
     * @return app用户注册记录集合
     */
    public List<DeviceUserRegister> selectDeviceUserRegisterList(DeviceUserRegister deviceUserRegister);

    /**
     * 新增app用户注册记录
     * 
     * @param deviceUserRegister app用户注册记录
     * @return 结果
     */
    public int insertDeviceUserRegister(DeviceUserRegister deviceUserRegister);

    /**
     * 修改app用户注册记录
     * 
     * @param deviceUserRegister app用户注册记录
     * @return 结果
     */
    public int updateDeviceUserRegister(DeviceUserRegister deviceUserRegister);

    /**
     * 删除app用户注册记录
     * 
     * @param regId app用户注册记录主键
     * @return 结果
     */
    public int deleteDeviceUserRegisterByRegId(Long regId);

    /**
     * 批量删除app用户注册记录
     * 
     * @param regIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeviceUserRegisterByRegIds(Long[] regIds);

    /**
     * 根据code查询
     * @param regCode
     * @return
     */
    List<DeviceUserRegister> selectDeviceUserRegisterByCode(String regCode);
}
