package com.netease.miniadmin.mapper;

import com.github.pagehelper.Page;
import com.netease.miniadmin.dto.CountResultDto;
import com.netease.miniadmin.model.User;
import com.netease.miniadmin.model.UserKey;
import com.netease.miniadmin.model.UserWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(UserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    int insert(UserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    int insertSelective(UserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    UserWithBLOBs selectByPrimaryKey(UserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(User record);

    // 获取总用户数
    int getUserCount();

    /* 根据地点获取用户数 */
    int selectByCity(@Param("city")String city);

    List<CountResultDto> selectAllCitys();

    List<CountResultDto> selectAllages();

    List<CountResultDto> selectAllGenders();

    List<CountResultDto> selectWorkStatus();

    Page<User> selectAllUser();

    String selectOpenIdById (Integer id);



}