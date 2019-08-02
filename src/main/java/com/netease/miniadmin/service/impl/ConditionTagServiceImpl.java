package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.dto.CountResultDto;
import com.netease.miniadmin.mapper.ConditionTagMapper;
import com.netease.miniadmin.service.ConditionTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionTagServiceImpl implements ConditionTagService {
    @Autowired
    private ConditionTagMapper conditionTagMapper;

    /**
     * 返回每一个条件标签选择的人数
     * @return
     */
    @Override
    public List<CountResultDto> selectEveryConditionTagCount() {
        return conditionTagMapper.selectEveryConditionTagCount();
    }
}
