package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.common.Constant;
import com.netease.miniadmin.dto.CountResult;
import com.netease.miniadmin.dto.EchartResult;
import com.netease.miniadmin.mapper.DynamicsMapper;
import com.netease.miniadmin.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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
    public List<EchartResult> getDynamicDistribute(){
        List<CountResult> list = getDynamicsNum();
        ArrayList<Integer> countList = new ArrayList<>(Constant.DynamicDistribute.DYNAMICSECTIONNUM);
        ArrayList<EchartResult> arrayList = new ArrayList<>(Constant.DynamicDistribute.DYNAMICSECTIONNUM);
        for(int i = 0; i < Constant.DynamicDistribute.DYNAMICSECTIONNUM; i++){
            countList.add(0);
        }
        if(!CollectionUtils.isEmpty(list)){
            for(CountResult result: list){
                int num = result.getNum();
                if(num <= Constant.DynamicDistribute.DYNAMICNUMPOINT1){
                    countList.set(0, countList.get(0) + 1);
                }else if(num <= Constant.DynamicDistribute.DYNAMICNUMPOINT2){
                    countList.set(1, countList.get(1) + 1);
                }else if(num <= Constant.DynamicDistribute.DYNAMICNUMPOINT3){
                    countList.set(2, countList.get(2) + 1);
                }else if(num <= Constant.DynamicDistribute.DYNAMICNUMPOINT4){
                    countList.set(3, countList.get(3) + 1);
                }else{
                    countList.set(4, countList.get(4) + 1);
                }
            }
            for(int i = 0; i < countList.size(); i++){
                arrayList.add(new EchartResult(Constant.DynamicDistribute.getDynamicSection(i), countList.get(i)));
            }
            return arrayList;
        }
        return null;
    }
}
