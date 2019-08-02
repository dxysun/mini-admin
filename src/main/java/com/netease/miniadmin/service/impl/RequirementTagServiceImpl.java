package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.dto.CountResultDto;
import com.netease.miniadmin.mapper.RequirementTagMapper;
import com.netease.miniadmin.service.RequirementTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RequirementTagServiceImpl implements RequirementTagService {
    @Autowired
    private RequirementTagMapper requirementTagMapper;

    /**
     * 返回每一个需求标签选择的人数
     * @return
     */
    @Override
    public List<CountResultDto> selectEveryRequireTagCount() {
        return requirementTagMapper.selectEveryRequireTagCount();
    }
}
