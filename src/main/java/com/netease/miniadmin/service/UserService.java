package com.netease.miniadmin.service;

import com.github.pagehelper.Page;
import com.netease.miniadmin.dto.CountResultDto;
import com.netease.miniadmin.dto.MatchResultDto;
import com.netease.miniadmin.dto.UserMatchDto;
import com.netease.miniadmin.model.User;

import java.util.List;

public interface UserService {
    Integer getUserCount();


    // 根据地区查找人数
    Integer selectByCity(String city);

    // 获取所有地区与人数的键值对
    List<CountResultDto> selectAllCitys();



    List<CountResultDto> selectAllages();

    List<CountResultDto> selectAllGenders();

    List<CountResultDto> selectWorkStatus();

    List<CountResultDto> selectGenderRatio();

    List<CountResultDto> selectWorkStatusRatio();

    Page<User> getAllUsers();

    MatchResultDto getMatcherNumber(String openId);

    List<UserMatchDto> getUserMatch(int pageIndex, int pageSize);

    int deleteUser(Integer id);


}
