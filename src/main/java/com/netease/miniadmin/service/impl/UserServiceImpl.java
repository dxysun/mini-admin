package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.dto.CountResult;
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
    public List<CountResult> selectAllCitys() {
        return userMapper.selectAllCitys();
    }

    @Override
    public List<CountResult> selectAllages() {
        return userMapper.selectAllages();
    }

    @Override
    public List<CountResult> selectAllGenders() {
        List<CountResult> countResults =userMapper.selectAllGenders();
        for(CountResult c:countResults)
        {
            if(c.getField()=="0")
            {
                c.setField("女");
            }
            else
            {
                c.setField("男");
            }
        }
        return countResults;
    }

    @Override
    public List<CountResult> selectWorkStatus() {
        List<CountResult> countResults =userMapper.selectWorkStatus();
        for(CountResult c:countResults)
        {
            if(c.getField()=="0")
            {
                c.setField("学生党");
            }
            else
            {
                c.setField("工作党");
            }
        }
        return countResults;
    }


}
