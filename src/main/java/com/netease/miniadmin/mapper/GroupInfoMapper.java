package com.netease.miniadmin.mapper;

import com.netease.miniadmin.model.GroupInfo;

public interface GroupInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_info
     *
     * @mbggenerated
     */
    int insert(GroupInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_info
     *
     * @mbggenerated
     */
    int insertSelective(GroupInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_info
     *
     * @mbggenerated
     */
    GroupInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(GroupInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(GroupInfo record);
}