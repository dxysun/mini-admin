package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.mapper.SuperAdminMapper;
import com.netease.miniadmin.model.SuperAdmin;
import com.netease.miniadmin.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {
    @Autowired
    SuperAdminMapper superAdminMapper;
    @Override
    public Integer loginCheck(SuperAdmin superAdmin) {
        return superAdminMapper.selectBySuperAdmin(superAdmin);
    }
}
