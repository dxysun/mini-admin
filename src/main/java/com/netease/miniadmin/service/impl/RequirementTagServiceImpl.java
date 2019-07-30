package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.dto.CountResult;
import com.netease.miniadmin.mapper.RequirementTagMapper;
import com.netease.miniadmin.service.RequirementTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RequirementTagServiceImpl implements RequirementTagService {
    @Autowired
    private RequirementTagMapper requirementTagMapper;
    @Override
    public List<CountResult> selectEveryRequireTagCount() {
        return requirementTagMapper.selectEveryRequireTagCount();
    }
}
