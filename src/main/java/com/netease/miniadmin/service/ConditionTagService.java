package com.netease.miniadmin.service;

import com.netease.miniadmin.dto.CountResultDto;

import java.util.List;

public interface ConditionTagService {
    List<CountResultDto> selectEveryConditionTagCount();

}
