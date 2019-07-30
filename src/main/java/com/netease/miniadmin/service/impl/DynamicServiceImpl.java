package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.dto.CountResult;
import com.netease.miniadmin.mapper.DynamicsMapper;
import com.netease.miniadmin.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于处理用户动态日记的接口
 * @author Xiang Jiangnan
 * @date 20190730
 */
 @Service
 public class DynamicServiceImpl implements DynamicService {

     @Autowired
     private DynamicsMapper dynamicsMapper;

     /**
      * 此方法用于返回每个用户的日记数量
      * @return 返回用户日记数量的集合
      */
    @Override
    public List<CountResult> getDynamicsNum(){
        List<CountResult> list = dynamicsMapper.selectDynamicsNum();
        if(!CollectionUtils.isEmpty(list)){
            System.out.println(list.get(0).getNum());
                return list;
        }
        return null;
    }
}
