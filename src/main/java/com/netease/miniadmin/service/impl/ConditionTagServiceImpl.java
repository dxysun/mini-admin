package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.dto.CountResult;
import com.netease.miniadmin.mapper.ConditionTagMapper;
import com.netease.miniadmin.service.ConditionTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ConditionTagServiceImpl implements ConditionTagService {
    @Autowired
    private ConditionTagMapper conditionTagMapper;
    @Override
    public List<CountResult> selectEveryConditionTagCount() {
        return conditionTagMapper.selectEveryConditionTagCount();
    }
}
