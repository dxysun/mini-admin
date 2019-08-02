package com.netease.miniadmin.service.impl;

import com.github.pagehelper.Page;
import com.netease.miniadmin.dto.CountResult;
import com.netease.miniadmin.mapper.UserMapper;
import com.netease.miniadmin.model.User;
import com.netease.miniadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户总数
     * @return
     */
    @Override
    public Integer getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public Integer selectByCity(String city) {

        return userMapper.selectByCity(city);
    }

    /**
     * 返回地域分布
     * @return
     */
    @Override
    public List<CountResult> selectAllCitys() {
        return userMapper.selectAllCitys();
    }

    /**
     * 返回用户年龄分布，20岁以下多少人，20-30岁多少人，30岁以上多少人，未设置年龄多少人
     *
     * @return
     */
    @Override
    public List<CountResult> selectAllages() {
        List<CountResult> list = userMapper.selectAllages();
        List<CountResult> resultList = new ArrayList<CountResult>();
        CountResult c1 = new CountResult("20岁以下",0);
        CountResult c2 = new CountResult("20岁-24岁",0);
        CountResult c3 = new CountResult("25岁-30岁",0);
        CountResult c4 = new CountResult("30岁以上",0);
        CountResult c5 = new CountResult("未设置年龄",0);
        for (CountResult c : list) {
            if (c.getField() == null) {
                c5.setNum(c5.getNum() + 1);
                continue;
            }
            if (Integer.valueOf(c.getField()) < 20) {
                c1.setNum(c1.getNum() + 1);
            }
            if (Integer.valueOf(c.getField()) >= 20 && Integer.valueOf(c.getField()) <= 24) {
                c2.setNum(c2.getNum() + 1);
            }
            if (Integer.valueOf(c.getField()) >= 25 && Integer.valueOf(c.getField()) <= 30) {
                c3.setNum(c3.getNum() + 1);
            }
            if (Integer.valueOf(c.getField()) > 30) {
                c4.setNum(c4.getNum() + 1);
            }

        }
        resultList.add(c1);
        resultList.add(c2);
        resultList.add(c3);
        resultList.add(c4);
        resultList.add(c5);
        return resultList;
    }

    /**
     * 返回性别人数
     *
     * @return
     */
    @Override
    public List<CountResult> selectAllGenders() {
        List<CountResult> countResults = userMapper.selectAllGenders();
        for (CountResult c : countResults) {
            if (c.getField() == null) {
                c.setField("未知");
                continue;
            } else if (c.getField().equals("1")) {
                c.setField("男");
            } else {
                c.setField("女");
            }
        }
        return countResults;
    }

    /**
     * 返回性别比率
     * @return
     */
    @Override
    public List<CountResult> selectGenderRatio() {
        List<CountResult> countResults = selectAllGenders();
        List<CountResult> resultList = new ArrayList<CountResult>();
        CountResult boy = new CountResult();
        boy.setField("男");
        CountResult girl = new CountResult();
        girl.setField("女");
        CountResult unknown = new CountResult();
        unknown.setField("未知");
        int sum = getUserCount();
        for (CountResult c : countResults) {
            int ratio = c.getNum() * 100 / sum;
            if (c.getField().equals(boy.getField())) {
                boy.setNum(ratio);
            }
            if (c.getField().equals(girl.getField())) {
                girl.setNum(ratio);
            }
        }
        unknown.setNum(100 - boy.getNum() - girl.getNum());
        resultList.add(boy);
        resultList.add(girl);
        resultList.add(unknown);
        return resultList;
    }

    /**
     * 返回学生党和工作党人数
     * @return
     */
    @Override
    public List<CountResult> selectWorkStatus() {
        List<CountResult> countResults = userMapper.selectWorkStatus();
        for (CountResult c : countResults) {
            if (c.getField()==null) {
                c.setField("未知");
            } else if (c.getField().equals("1")){
                c.setField("工作党");
            }
            else
            {
                c.setField("学生党");
            }
        }
        return countResults;
    }

    /**
     * 返回学生党，工作党人数比例
     * @return
     */
    @Override
    public List<CountResult> selectWorkStatusRatio() {
        List<CountResult> countResults = selectWorkStatus();
        List<CountResult> resultList = new ArrayList<CountResult>();
        CountResult worker = new CountResult();
        worker.setField("工作党");
        CountResult student = new CountResult();
        student.setField("学生党");
        int sum = getUserCount();
        for (CountResult c : countResults) {
            int ratio = c.getNum() * 100 / sum;
            if (c.getField().equals(worker.getField())) {
                worker.setNum(ratio);
            }
        }
        student.setNum(100 - worker.getNum());
        resultList.add(worker);
        resultList.add(student);
        return resultList;
    }

    @Override
    public Page<User> getAllUsers() {
        return userMapper.selectAllUser();
    }
}
