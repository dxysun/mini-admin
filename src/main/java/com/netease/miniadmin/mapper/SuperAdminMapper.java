package com.netease.miniadmin.mapper;

import com.github.pagehelper.Page;
import com.netease.miniadmin.dto.CountResultDto;
import com.netease.miniadmin.model.SuperAdmin;
import com.netease.miniadmin.model.User;
import com.netease.miniadmin.model.UserKey;
import com.netease.miniadmin.model.UserWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SuperAdminMapper {

    Integer selectBySuperAdmin(@Param("superAdmin") SuperAdmin superAdmin);


}