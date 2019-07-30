package com.netease.miniadmin.service;

import com.netease.miniadmin.dto.CountResult;

import java.util.List;
import java.util.Map;

public interface RequirementTagService {
    List<CountResult> selectEveryRequireTagCount();
}
