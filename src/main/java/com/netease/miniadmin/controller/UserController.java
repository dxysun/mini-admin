package com.netease.miniadmin.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netease.miniadmin.dto.CountResultDto;
import com.netease.miniadmin.dto.EchartResultDto;
import com.netease.miniadmin.dto.UserMatchDto;
import com.netease.miniadmin.model.User;
import com.netease.miniadmin.service.DynamicService;
import com.netease.miniadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DynamicService dynamicService;

    @RequestMapping("/getUserCount")
    public Map<String,Object> getUserCount(){
       Map <String,Object> map = new HashMap<String, Object>();
       Integer count =userService.getUserCount();
       map.put("data",count);
       map.put("success",true);
       return map;
   }

    /**
     * 用于返回每个用户动态数目的接口
     * @author Xiang Jiangnan
     * @return
     */
   @RequestMapping("/getDynamicsNum")
    public List<CountResultDto> getDynamicsNum(){
       List<CountResultDto> list = dynamicService.getDynamicsNum();
       if(!CollectionUtils.isEmpty(list)){
           return list;
       }
       return null;
   }

    // 根据地区查找人数
    @PostMapping("/getUserByLocation")
    public Integer getUserByLocation(@RequestParam(value = "city",defaultValue = "郑州")String city)
   {
       Integer num = userService.selectByCity(city);
       return num;
   }

    @GetMapping("/getAllCitys")
    public Integer getAllCitys() {
        Map<String, Integer> map = new HashMap<>();
        List<CountResultDto> list = new ArrayList<>();
        list = userService.selectAllCitys();
        return 1;
    }

    @GetMapping(value = "/dynamicDistributeBar")
    public String dynamicDistributeBar()
    {
        return "/echarts/dynamicbar";
    }

    /**
     * 用于返回日记区间的用户分布
     * @author Xiang Jiangnan
     * @return
     */
    @RequestMapping("/getDynamicDistribute")
    @ResponseBody
    public String getDynamicDistribute(){
        List<EchartResultDto> list = dynamicService.getDynamicDistribute();
        String data = JSON.toJSONString(list);
        return data;
    }

    @RequestMapping("/getAllUserInfo")
    public ModelAndView getAllUserInfo(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        PageHelper .startPage(pageNo,pageSize);
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<User> pageInfo = new PageInfo<>(userService.getAllUsers());
        modelAndView.addObject("userList",pageInfo);
        modelAndView.setViewName("admin/list");
        return modelAndView;
    }

    @RequestMapping("/getUserMatchInfo")
    public ModelAndView getUserMatchInfo(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserMatchDto> userMatchDtoList = userService.getUserMatch();
        modelAndView.addObject("matchList",userMatchDtoList);
        modelAndView.setViewName("admin/usermatchlist");
        return modelAndView;
    }

    @GetMapping("/index")
    public String getindex()
    {
        return "index";
    }

    @GetMapping("/wel")
    public String welcome()
    {
        return "welcome";
    }

    @GetMapping(value = "/genderpie")
    public String genderpie()
    {
        return "/echarts/genderchart";
    }

    @PostMapping(value = "/getgenderdata")
    @ResponseBody
    public String getgenderdata()
    {
        List<CountResultDto> list =userService.selectAllGenders();
        List<EchartResultDto> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            EchartResultDto result=new EchartResultDto();
            result.setName(list.get(i).getField());
            result.setValue(list.get(i).getNum());
            list1.add(result);
        }
        String data = JSON.toJSONString(list1);
        return data;
    }

    @GetMapping(value = "/locationpie")
    public String locationpie()
    {
        return "/echarts/locationchart";
    }

    @PostMapping(value = "/getlocationdata")
    @ResponseBody
    public String getlocationdata()
    {
        List<CountResultDto> list =userService.selectAllCitys();
        List<EchartResultDto> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            EchartResultDto result=new EchartResultDto();
            result.setName(list.get(i).getField());
            result.setValue(list.get(i).getNum());
            list1.add(result);
        }
        String data = JSON.toJSONString(list1);
        return data;
    }

    @GetMapping(value = "/workstatuspie")
    public String workstatuspie()
    {
        return "/echarts/workstatuschart";
    }


    @PostMapping(value = "/getworkstatusdata")
    @ResponseBody
    public String getworkstatusdata()
    {
        List<CountResultDto> list =userService.selectWorkStatus();
        List<EchartResultDto> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            EchartResultDto result=new EchartResultDto();
            result.setName(list.get(i).getField());
            result.setValue(list.get(i).getNum());
            list1.add(result);
        }
        String data = JSON.toJSONString(list1);
        return data;
    }
    @GetMapping(value = "/agepie")
    public String agepie()
    {
        return "/echarts/agechart";
    }

    @PostMapping(value = "/getagedata")
    @ResponseBody
    public String getagedata()
    {
        List<CountResultDto> list =userService.selectAllages();
        List<EchartResultDto> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            EchartResultDto result=new EchartResultDto();
            result.setName(list.get(i).getField());
            result.setValue(list.get(i).getNum());
            list1.add(result);
        }
        String data = JSON.toJSONString(list1);
        return data;
    }


}
