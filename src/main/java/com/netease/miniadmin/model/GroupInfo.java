package com.netease.miniadmin.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "group_info")
public class GroupInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 群ID
     */
    private String groupId;

    /**
     * 群名称
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 群创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取群ID
     *
     * @return groupid - 群ID
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 设置群ID
     *
     * @param groupId 群ID
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * 获取群名称
     *
     * @return group_name - 群名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置群名称
     *
     * @param groupName 群名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * 获取群创建时间
     *
     * @return create_time - 群创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置群创建时间
     *
     * @param createTime 群创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}