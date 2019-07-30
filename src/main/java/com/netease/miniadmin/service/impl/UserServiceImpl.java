package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.mapper.UserMapper;
import com.netease.miniadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer getUserCount() {
        return userMapper.getUserCount();
    }
}
