package com.netease.miniadmin.service;

import com.netease.miniadmin.dto.CountResult;
import com.netease.miniadmin.dto.EchartResult;

import java.util.List;

public interface DynamicService {
    List<CountResult> getDynamicsNum();
    List<EchartResult> getDynamicDistribute();
}
