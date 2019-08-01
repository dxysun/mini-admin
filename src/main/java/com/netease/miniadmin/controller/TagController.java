package com.netease.miniadmin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netease.miniadmin.model.Tag;
import com.netease.miniadmin.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/tag")
public class TagController {
    @Autowired
    TagService tagService;
    @ResponseBody
    @RequestMapping("/getTagsByType")
    public ModelAndView getTagsByType(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,Integer type){
        PageHelper.startPage(pageNo,pageSize);
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Tag> pageInfo = new PageInfo<Tag>(tagService.selectTagsByType(type));
        modelAndView.addObject("tags",pageInfo);
        if(type == 1){
            modelAndView.setViewName("admin/category1");
        }
        if(type == 2){
            modelAndView.setViewName("admin/category4");
        }
        if(type == 3){
            modelAndView.setViewName("admin/category2");
        }
        if(type == 0){
            modelAndView.setViewName("admin/category3");
        }

        return  modelAndView;
    }
    @RequestMapping("/sendAddCategory")
    public String sendAddCategory(){
        return "/admin/categoryadd";
    }
}
