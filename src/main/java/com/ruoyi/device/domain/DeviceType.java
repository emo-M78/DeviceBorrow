package com.ruoyi.device.domain;

import java.util.Date;

public class DeviceType {
    private Long typeId;
    /*主键*/
    private String typeName;
    /*类型名称*/
    private String typeRemark;
    /*说明*/
    private int typeStatus;
    /*类型状态：-1删除，0正常，1禁用*/
    private Long createBy;
    /*创建者id*/
    private Date createTime;
    /*创建时间*/
    private Long updateBy;
    /*更新者id*/
    private Date updateTime;
    /*更新时间*/

    public Long getTypeId() {
        return typeId;
    }
    //生成getter方法和setter方法
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeRemark() {
        return typeRemark;
    }

    public void setTypeRemark(String typeRemark) {
        this.typeRemark = typeRemark;
    }

    public int getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(int typeStatus) {
        this.typeStatus = typeStatus;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    //生成getter方法

    public DeviceType() {
    }

    public DeviceType(Long typeId, String typeName, String typeRemark, int typeStatus, Long createBy, Date createTime, Long updateBy, Date updateTime) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.typeRemark = typeRemark;
        this.typeStatus = typeStatus;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

}
