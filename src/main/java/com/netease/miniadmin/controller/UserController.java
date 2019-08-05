package com.netease.miniadmin.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netease.miniadmin.dto.CountResultDto;
import com.netease.miniadmin.dto.EchartResultDto;
import com.netease.miniadmin.dto.UserMatchDto;
import com.netease.miniadmin.model.SuperAdmin;
import com.netease.miniadmin.model.User;
import com.netease.miniadmin.model.UserFeedback;
import com.netease.miniadmin.service.DynamicService;
import com.netease.miniadmin.service.GroupRelationService;
import com.netease.miniadmin.service.SuperAdminService;
import com.netease.miniadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private GroupRelationService groupRelationService;

    @RequestMapping("/getUserCount")
    public Map<String,Object> getUserCount(){
       Map <String,Object> map = new HashMap<String, Object>();
       Integer count =userService.getUserCount();
       map.put("data",count);
       map.put("success",true);
       return map;
   }

    @GetMapping(value = "/topDynamicNumBar")
    public String topDynamicNumBar()
    {
        return "echarts/topdynamicbar";
    }

   @RequestMapping("/getTopFiveDynamicNum")
   @ResponseBody
    public String getTopFiveDynamicNum(){
       List<EchartResultDto> list = dynamicService.getTopFiveDynamicNum();
       if(!CollectionUtils.isEmpty(list)){
           return JSON.toJSONString(list);
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
        return "echarts/dynamicbar";
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
    public ModelAndView getUserMatchInfo(@RequestParam(defaultValue = "1") Integer pageNo,@RequestParam(defaultValue = "10") Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/usermatchlist");
        try{
            PageInfo<UserMatchDto> pageInfo = new PageInfo<>(userService.getUserMatch());
            if (pageInfo.getList().size() == 0 || pageInfo.getList() == null){
                return modelAndView;
            }else{
                modelAndView.addObject("matchList",pageInfo);
                return modelAndView;
            }
        }catch (Exception e){
            return modelAndView;

        }
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
        return "echarts/genderchart";
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
        return "echarts/locationchart";
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
        return "echarts/workstatuschart";
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
        return "echarts/agechart";
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


    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteTag(Integer id){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            int num = userService.deleteUser(id);
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


    @GetMapping(value = "/grouppie")
    public String grouppie()
    {
        return "echarts/groupchart";
    }

//    @GetMapping(value = "/login")
//    public String login(){return "login";}

    @PostMapping(value = "/getgroupdata")
    @ResponseBody
    public String getgroupdata()
    {
        List<EchartResultDto> list =groupRelationService.getGroupNum();
        String data = JSON.toJSONString(list);
        return data;
    }



}
