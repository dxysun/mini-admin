package com.netease.miniadmin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.netease.miniadmin.dto.CountResult;
import com.netease.miniadmin.dto.EchartResult;
import com.netease.miniadmin.model.User;
import com.netease.miniadmin.service.DynamicService;
import com.netease.miniadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public List<CountResult> getDynamicsNum(){
       List<CountResult> list = dynamicService.getDynamicsNum();
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
        List<CountResult> list = new ArrayList<>();
        list = userService.selectAllCitys();
        return 1;
    }

    /**
     * 用于返回日记区间的用户分布
     * @author Xiang Jiangnan
     * @return
     */
    @RequestMapping("/getDynamicDistribute")
    public List<Integer> getDynamicDistribute(){
        List<Integer> arrayList = dynamicService.getDynamicDistribute();
        if(!CollectionUtils.isEmpty(arrayList)){
            return arrayList;
        }
        return null;
    }
    @RequestMapping("/getAllUserInfo")
    public ModelAndView getAllUserInfo(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        PageHelper .startPage(pageNo,pageSize);
        ModelAndView modelAndView = new ModelAndView();
//        List<User> userList = userService.getAllUsers();
//        Integer userNum = userService.getUserCount();
        PageInfo<User> pageInfo = new PageInfo<>(userService.getAllUsers());
        modelAndView.addObject("userList",pageInfo);
//        modelAndView.addObject("userNum",userNum);
        modelAndView.setViewName("admin/list");
        return modelAndView;
    }

    @GetMapping("/index")
    public String getddd()
    {
        return "index";
    }

    @GetMapping("/wel")
    public String getddddd()
    {
        return "welcome";
    }

    @GetMapping(value = "/genderpie")
    public String genderpie()
    {


        return "/echarts/echarts4";
    }

    @PostMapping(value = "/getgenderdata")
    @ResponseBody
    public String getgenderdata()
    {
        List<CountResult> list =userService.selectAllGenders();
        List<EchartResult> list1=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            EchartResult result=new EchartResult();
            result.setName(list.get(i).getField());
            result.setValue(list.get(i).getNum());
            list1.add(result);
        }
        String data = JSON.toJSONString(list1);
        return data;
    }


}
