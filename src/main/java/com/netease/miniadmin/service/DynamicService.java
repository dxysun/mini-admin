package com.netease.miniadmin.service;

import com.netease.miniadmin.dto.CountResultDto;
import com.netease.miniadmin.dto.EchartResultDto;

import java.util.List;

public interface DynamicService {
    List<CountResultDto> getDynamicsNum();
    List<EchartResultDto> getDynamicDistribute();
}
