package com.netease.miniadmin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netease.miniadmin.common.util.AjaxObject;
import com.netease.miniadmin.common.util.Result;
import com.netease.miniadmin.model.UserFeedback;
import com.netease.miniadmin.service.UserFeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XiaBin
 * @date 2019-07-31 11:24
 */
@Controller
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
    @ResponseBody
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
    @ResponseBody
    public Map<String, Object> deleteById(@RequestParam("id") Integer id){
        if (id == null){
            AjaxObject.error("无法获得反馈id");
        }
        Map<String,Object> map = new HashMap<>(16);
        try{
            int num = userFeedbackService.deleteByPrimaryKey(id);
            if(num == 1){
                map.put("success",true);
            }else{
                map.put("success",false);
            }
        }catch (Exception e){
            map.put("success",false);
            map.put("errMsg",e.toString());
            return map;
        }
        return map;
    }

    /**
     * 分页查询反馈数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/getPageQueryInfo")
    public ModelAndView pageQuery(@RequestParam(defaultValue = "1") Integer pageNo,@RequestParam(defaultValue = "10") Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("feedback/allFeedback");
        try {
            PageInfo<UserFeedback> pageInfo = new PageInfo<>(userFeedbackService.pageQuery());
            if (pageInfo.getList().size() == 0 || pageInfo.getList() == null){
                return modelAndView;
            }else{
                modelAndView.addObject("feedbackLists",pageInfo);
                return modelAndView;
            }
        }catch (Exception e){
            return modelAndView;
        }
    }

}
