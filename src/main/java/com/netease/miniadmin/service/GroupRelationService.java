package com.netease.miniadmin.service;

import com.netease.miniadmin.dto.CountResultDto;
import com.netease.miniadmin.dto.EchartResultDto;

import java.util.List;

public interface GroupRelationService {
    /**
     * 统计分布，参与一个群的有几个人，两个群的有几个人。。。
     * @return
     */
    List<EchartResultDto> getGroupNum();
}
