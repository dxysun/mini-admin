package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.mapper.UserMapper;
import com.netease.miniadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public Integer selectByCity(String city) {

        return userMapper.selectByCity(city);
    }

    @Override
    public List<Map<String, Integer>> selectAllCitys() {
        return userMapper.selectAllCitys();
    }
}
