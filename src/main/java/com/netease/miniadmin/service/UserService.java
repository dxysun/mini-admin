package com.netease.miniadmin.service;

import com.github.pagehelper.Page;
import com.netease.miniadmin.dto.CountResult;
import com.netease.miniadmin.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    Integer getUserCount();


    // 根据地区查找人数
    Integer selectByCity(String city);

    // 获取所有地区与人数的键值对
    List<CountResult> selectAllCitys();



    List<CountResult> selectAllages();

    List<CountResult> selectAllGenders();

    List<CountResult> selectWorkStatus();

    List<CountResult> selectGenderRatio();

    List<CountResult> selectWorkStatusRatio();

    Page<User> getAllUsers();

}
