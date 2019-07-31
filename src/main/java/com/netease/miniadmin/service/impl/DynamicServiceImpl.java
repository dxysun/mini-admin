package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.common.Constant;
import com.netease.miniadmin.dto.CountResult;
import com.netease.miniadmin.mapper.DynamicsMapper;
import com.netease.miniadmin.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
            return list;
        }
        return null;
    }

    /**
     * 此方法用于统计不同日记区间的用户数，这里暂时将日记数量划分为5个区间，[0,5],[6,10],[10.20],[20,30]和>30
     * @return 返回不同日记区间的用户数的集合
     */
    @Override
    public List<Integer> getDynamicDistribute(){
        List<CountResult> list = getDynamicsNum();
        ArrayList<Integer> arrayList = new ArrayList<>(Constant.DynamicDistribute.DYNAMICSECTIONNUM);
        for(int i = 0; i < Constant.DynamicDistribute.DYNAMICSECTIONNUM; i++){
            arrayList.add(0);
        }
        if(!CollectionUtils.isEmpty(list)){
            for(CountResult result: list){
                int num = result.getNum();
                if(num <= Constant.DynamicDistribute.DYNAMICNUMPOINT1){
                    arrayList.set(0, arrayList.get(0)+ 1);
                }else if(num <= Constant.DynamicDistribute.DYNAMICNUMPOINT2){
                    arrayList.set(1, arrayList.get(1)+ 1);
                }else if(num <= Constant.DynamicDistribute.DYNAMICNUMPOINT3){
                    arrayList.set(2, arrayList.get(2)+ 1);
                }else if(num <= Constant.DynamicDistribute.DYNAMICNUMPOINT4){
                    arrayList.set(3, arrayList.get(3)+ 1);
                }else{
                    arrayList.set(4, arrayList.get(4)+ 1);
                }
            }
            return arrayList;
        }
        return null;
    }
}
