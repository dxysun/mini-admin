package com.netease.miniadmin.model;

import java.util.Date;

public class DynamicsTemplate {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dynamics_template.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dynamics_template.diary
     *
     * @mbggenerated
     */
    private String diary;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dynamics_template.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dynamics_template.poster
     *
     * @mbggenerated
     */
    private String poster;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dynamics_template.id
     *
     * @return the value of dynamics_template.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dynamics_template.id
     *
     * @param id the value for dynamics_template.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dynamics_template.diary
     *
     * @return the value of dynamics_template.diary
     *
     * @mbggenerated
     */
    public String getDiary() {
        return diary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dynamics_template.diary
     *
     * @param diary the value for dynamics_template.diary
     *
     * @mbggenerated
     */
    public void setDiary(String diary) {
        this.diary = diary == null ? null : diary.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dynamics_template.create_time
     *
     * @return the value of dynamics_template.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dynamics_template.create_time
     *
     * @param createTime the value for dynamics_template.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dynamics_template.poster
     *
     * @return the value of dynamics_template.poster
     *
     * @mbggenerated
     */
    public String getPoster() {
        return poster;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dynamics_template.poster
     *
     * @param poster the value for dynamics_template.poster
     *
     * @mbggenerated
     */
    public void setPoster(String poster) {
        this.poster = poster == null ? null : poster.trim();
    }
}