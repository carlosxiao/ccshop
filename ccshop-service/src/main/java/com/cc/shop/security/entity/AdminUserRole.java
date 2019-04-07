package com.cc.shop.security.entity;

import java.util.Date;

import com.cc.shop.framework.base.entity.BaseEntity;

public class AdminUserRole extends BaseEntity {

	private static final long serialVersionUID = -8197074496686832319L;

	private Long adminUserId;

    private Long adminRoleId;

    private Date createTime;

    private Date updateTime;

    public Long getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Long adminUserId) {
        this.adminUserId = adminUserId;
    }

    public Long getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(Long adminRoleId) {
        this.adminRoleId = adminRoleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}