package com.netease.miniadmin.service.impl;

import com.netease.miniadmin.mapper.UserFeedbackMapper;
import com.netease.miniadmin.model.PageQuery;
import com.netease.miniadmin.model.UserFeedback;
import com.netease.miniadmin.service.UserFeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XiaBin
 * @date 2019-07-31 11:18
 */
@Service
public class UserFeedbackServiceImpl implements UserFeedbackService {

    @Resource
    private UserFeedbackMapper userFeedbackMapper;

    @Override
    public UserFeedback selectByPrimaryKey(Integer id) {
        return userFeedbackMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        UserFeedback userFeedback = selectByPrimaryKey(id);
        if (userFeedback.getStatus() == 1){
            return 0;
        }
        return userFeedbackMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserFeedback> pageQuery(Integer currentIndex, Integer pageSize) {
        PageQuery pageQuery = new PageQuery();
        pageQuery.setCurrentIndex(currentIndex);
        pageQuery.setPageSize(pageSize);
        return userFeedbackMapper.pageQuery(pageQuery);
    }
}
