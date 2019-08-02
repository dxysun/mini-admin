package com.netease.miniadmin;


import com.netease.miniadmin.dto.CountResultDto;
import com.netease.miniadmin.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiniAdminApplicationTests {
    @Autowired
    TagService tagService;
    @Autowired
    RequirementTagService requirementTagService;
    @Autowired
    ConditionTagService conditionTagService;
    @Autowired
    GroupRelationService groupRelationService;
    @Autowired
    UserService userService;


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void contextLoads() {
        List<CountResultDto> list = userService.selectWorkStatusRatio();
        for (CountResultDto result : list) {
            // System.out.println(result);
            System.out.println(result.getField() + ":" + result.getNum());
        }

    }

    @Test
    public void  getMatcherNumber() {
        //redisUtil.set("qqqqqqqqqq","qqqqqwwwww");
        String dd= (String) redisTemplate.opsForValue().get("sess");
        System.out.println("133");
        //System.out.println(object);
    }
}
