package com.netease.miniadmin.service;

import com.netease.miniadmin.model.PageQuery;
import com.netease.miniadmin.model.UserFeedback;
import org.omg.CORBA.INTERNAL;

import java.util.List;

/**
 * @author XiaBin
 * @date 2019-07-31 11:16
 */
public interface UserFeedbackService {
    /**
     * 通过id查找反馈信息
     * @param id
     * @return
     */
    UserFeedback selectByPrimaryKey(Integer id);

    /**
     * 通过id修改反馈信息为不可用
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 分页查询反馈信息
     * @return
     */
    List<UserFeedback> pageQuery(Integer currentIndex, Integer pageSize);
}
