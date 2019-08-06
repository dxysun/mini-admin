package com.netease.miniadmin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netease.miniadmin.model.Tag;
import com.netease.miniadmin.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        return "admin/categoryadd";
    }

    @RequestMapping("/sendEditCategory")
    public String sendEditCategory(HttpServletRequest request){
        return "admin/categoryedit";
    }


    @RequestMapping(value = "/deleteTag",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteTag(Integer id){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            int num = tagService.deleteTag(id);
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

    @RequestMapping(value = "/addTag", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> addTag(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        Tag tag = null;
        String tagtStr = request.getParameter("tagStr");
        try {
            tag = mapper.readValue(tagtStr, Tag.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        tag.setModifyTime(new Date());
        tag.setCreateTime(new Date());
        try{
            tagService.insertTag(tag);
        }catch (Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }

        modelMap.put("success",true);
        return modelMap;

    }

    @RequestMapping("/getTagById")
    @ResponseBody
    private Map<String, Object> getTagById(@RequestParam Integer id){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if(id !=null){
            Tag tag = tagService.selectTagById(id);
            if(tag !=null){
                modelMap.put("tag",tag);
                modelMap.put("success", true);
            }else{
                modelMap.put("success", false);
            }
        }else{
            modelMap.put("success", false);
        }
        return modelMap;
    }

    @RequestMapping(value = "/updateTag", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> updateTag(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        Tag tag = null;
        String tagtStr = request.getParameter("tagStr");
        try {
            tag = mapper.readValue(tagtStr, Tag.class);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        tag.setModifyTime(new Date());
        try{
            tagService.updateTag(tag);
        }catch (Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }

        modelMap.put("success",true);
        return modelMap;

    }


}
