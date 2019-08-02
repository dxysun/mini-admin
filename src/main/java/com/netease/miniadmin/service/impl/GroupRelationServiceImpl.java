package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.dto.CountResultDto;
import com.netease.miniadmin.mapper.GroupRelationMapper;
import com.netease.miniadmin.service.GroupRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupRelationServiceImpl implements GroupRelationService {
    @Autowired
    private GroupRelationMapper groupRelationMapper;

    @Override
    /**
     * 返回统计分布，参与一个群的有几个，两个群的有几个，参与n个群的有几个
     * author cuiyang
     */
    public List<CountResultDto> getGroupNum() {
        List<CountResultDto> list = groupRelationMapper.getUserMathchGroupNum();
        List<CountResultDto> resultList = new ArrayList<CountResultDto>();
        int maxGroupNum = -1;
        //获取用户最多的匹配群数
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNum() > maxGroupNum) {
                maxGroupNum = list.get(i).getNum();
            }
        }
        //遍历统计
        for (int i = 1; i <= maxGroupNum; i++) {
            int t = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getNum() == i) {
                    t++;
                }
            }
            CountResultDto result = new CountResultDto();
            result.setField(String.valueOf(i));
            result.setNum(t);
            resultList.add(result);
        }
        return resultList;
    }
}
