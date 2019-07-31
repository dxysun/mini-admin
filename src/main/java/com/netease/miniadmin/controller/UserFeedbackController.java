package com.netease.miniadmin.controller;

import com.netease.miniadmin.common.util.AjaxObject;
import com.netease.miniadmin.common.util.Result;
import com.netease.miniadmin.model.UserFeedback;
import com.netease.miniadmin.service.UserFeedbackService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XiaBin
 * @date 2019-07-31 11:24
 */
@RestController
@RequestMapping("/admin/userFeedback")
public class UserFeedbackController {

    @Resource
    private UserFeedbackService userFeedbackService;

    /**
     * 通过反馈id获取数据
     * @param id
     * @return
     */
    @RequestMapping("/getFeedbackById")
    public Result getUserCount(@RequestParam("id") Integer id){
        if (id == null){
            AjaxObject.error("不能获得反馈id");
        }
        UserFeedback userFeedback;
        try {
            userFeedback = userFeedbackService.selectByPrimaryKey(id);
        }catch (Exception e){
            return AjaxObject.error(e);
        }
        return AjaxObject.success("查询单个反馈信息成功",userFeedback);
    }

    /**
     * 通过id删除反馈信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public Result deleteById(@RequestParam("id") Integer id){
        if (id == null){
            AjaxObject.error("无法获得反馈id");
        }
        try {
            int result = userFeedbackService.deleteByPrimaryKey(id);
            if (result == 1){
                return AjaxObject.success("删除成功");
            }else{
                return AjaxObject.success("删除失败");
            }
        }catch (Exception e){
            return AjaxObject.error(e);
        }
    }

    /**
     * 分页查询反馈数据
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/getPageQueryInfo")
    public Result pageQuery(@RequestParam("currentPage") Integer currentPage,@RequestParam("pageSize") Integer pageSize){
        List<UserFeedback> list;
        try {
            int currentIndex = (currentPage - 1)*pageSize;
            list = userFeedbackService.pageQuery(currentIndex,pageSize);
            if (list.size() == 0 || list == null){
                return AjaxObject.success("数据为空",null);
            }else{
                return AjaxObject.success("查询数据成功",list);
            }
        }catch (Exception e){
            return AjaxObject.error(e);
        }
    }
}
