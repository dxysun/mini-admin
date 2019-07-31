package com.netease.miniadmin.controller;

import com.netease.miniadmin.dto.CountResult;
import com.netease.miniadmin.service.DynamicService;
import com.netease.miniadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
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
}
