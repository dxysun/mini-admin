package com.netease.miniadmin;


import com.netease.miniadmin.dto.CountResult;
import com.netease.miniadmin.model.GroupRelation;
import com.netease.miniadmin.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Test
    public void contextLoads() {
        List<CountResult> list = userService.selectWorkStatusRatio();
        for (CountResult result : list) {
            // System.out.println(result);
            System.out.println(result.getField() + ":" + result.getNum());
        }

    }
}
