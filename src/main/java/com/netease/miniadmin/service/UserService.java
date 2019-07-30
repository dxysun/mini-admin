package com.netease.miniadmin.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    Integer getUserCount();

    Integer selectByCity(String city);

    List<Map<String,Integer>> selectAllCitys();
}
