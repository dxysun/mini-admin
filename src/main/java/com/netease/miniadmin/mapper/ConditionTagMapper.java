package com.netease.miniadmin.mapper;

import com.netease.miniadmin.model.ConditionTag;

public interface ConditionTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table condition_tag
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table condition_tag
     *
     * @mbggenerated
     */
    int insert(ConditionTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table condition_tag
     *
     * @mbggenerated
     */
    int insertSelective(ConditionTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table condition_tag
     *
     * @mbggenerated
     */
    ConditionTag selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table condition_tag
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ConditionTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table condition_tag
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ConditionTag record);
}