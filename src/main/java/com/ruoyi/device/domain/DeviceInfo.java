package com.ruoyi.device.domain;

import com.ruoyi.common.annotation.Excel;

import java.util.Date;

public class DeviceInfo {
    private  Long deviceId;
    private Long typeId;
    @Excel(name = "设备名称")
    private String deviceName;
    @Excel(name = "设备型号")
    private String deviceModel;
    private String deviceImg;
    @Excel(name = "设备说明")
    private String deviceRemark;
    @Excel(name = "设备状态",readConverterExp = "-1=废弃,0=正常,1=借出,2=维修")
    private Integer deviceStatus;
    private String createBy;
    @Excel(name = "创建时间",dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    /*用于分页查询*/
    @Excel(name = "分类名称")
    private String typeName;
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    //生成无参构造方法
    public DeviceInfo() {

    }
    //生成有参构造方法
    public DeviceInfo(Long deviceId, Long typeId, String deviceName, String deviceModel, String deviceImg, String deviceRemark, Integer deviceStatus, String createBy, Date createTime, String updateBy, Date updateTime) {
        this.deviceId = deviceId;
        this.typeId = typeId;
        this.deviceName = deviceName;
        this.deviceModel = deviceModel;
        this.deviceImg = deviceImg;
        this.deviceRemark = deviceRemark;
        this.deviceStatus = deviceStatus;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }
    //生成getter和setter方法

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceImg() {
        return deviceImg;
    }

    public void setDeviceImg(String deviceImg) {
        this.deviceImg = deviceImg;
    }

    public String getDeviceRemark() {
        return deviceRemark;
    }

    public void setDeviceRemark(String deviceRemark) {
        this.deviceRemark = deviceRemark;
    }

    public Integer getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
