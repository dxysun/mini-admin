package com.netease.miniadmin.model;

import java.util.Date;

public class RequirementTag {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column requirement_tag.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column requirement_tag.open_id
     *
     * @mbggenerated
     */
    private String openId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column requirement_tag.require_tag_name
     *
     * @mbggenerated
     */
    private String requireTagName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column requirement_tag.require_tag_id
     *
     * @mbggenerated
     */
    private Integer requireTagId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column requirement_tag.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column requirement_tag.modify_time
     *
     * @mbggenerated
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column requirement_tag.necessary
     *
     * @mbggenerated
     */
    private Integer necessary;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column requirement_tag.id
     *
     * @return the value of requirement_tag.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column requirement_tag.id
     *
     * @param id the value for requirement_tag.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column requirement_tag.open_id
     *
     * @return the value of requirement_tag.open_id
     *
     * @mbggenerated
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column requirement_tag.open_id
     *
     * @param openId the value for requirement_tag.open_id
     *
     * @mbggenerated
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column requirement_tag.require_tag_name
     *
     * @return the value of requirement_tag.require_tag_name
     *
     * @mbggenerated
     */
    public String getRequireTagName() {
        return requireTagName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column requirement_tag.require_tag_name
     *
     * @param requireTagName the value for requirement_tag.require_tag_name
     *
     * @mbggenerated
     */
    public void setRequireTagName(String requireTagName) {
        this.requireTagName = requireTagName == null ? null : requireTagName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column requirement_tag.require_tag_id
     *
     * @return the value of requirement_tag.require_tag_id
     *
     * @mbggenerated
     */
    public Integer getRequireTagId() {
        return requireTagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column requirement_tag.require_tag_id
     *
     * @param requireTagId the value for requirement_tag.require_tag_id
     *
     * @mbggenerated
     */
    public void setRequireTagId(Integer requireTagId) {
        this.requireTagId = requireTagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column requirement_tag.create_time
     *
     * @return the value of requirement_tag.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column requirement_tag.create_time
     *
     * @param createTime the value for requirement_tag.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column requirement_tag.modify_time
     *
     * @return the value of requirement_tag.modify_time
     *
     * @mbggenerated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column requirement_tag.modify_time
     *
     * @param modifyTime the value for requirement_tag.modify_time
     *
     * @mbggenerated
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column requirement_tag.necessary
     *
     * @return the value of requirement_tag.necessary
     *
     * @mbggenerated
     */
    public Integer getNecessary() {
        return necessary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column requirement_tag.necessary
     *
     * @param necessary the value for requirement_tag.necessary
     *
     * @mbggenerated
     */
    public void setNecessary(Integer necessary) {
        this.necessary = necessary;
    }
}