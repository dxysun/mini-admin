package com.netease.miniadmin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.miniadmin.common.util.Constant;
import com.netease.miniadmin.common.util.RedisUtil;
import com.netease.miniadmin.dto.MatchResultDto;
import com.netease.miniadmin.model.param.MatchingResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void  getMatcherNumber() {
        //redisUtil.set("qqqqqqqqqq","qqqqqwwwww");
        //String object = (String) redisUtil.get("orq0K45uyGX-1QHmtvSyILiT-F6M");
        MatchResultDto matchResultDto =new MatchResultDto(0,0);
        int totalnumber = 0;
        int matchnumber = 0;
        String mapJsonString = (String) redisUtil.get("orq0K45uyGX-1QHmtvSyILiT-F6M");
        JSONObject matchingResultMap = JSON.parseObject(mapJsonString);
        Set<String> groupset = matchingResultMap.keySet();

        for(String s:groupset)
        {
            System.out.println(s);
            JSONArray matchingResultJsons = (JSONArray) matchingResultMap.get(s);
            System.out.println(matchingResultJsons);
            for(int i=0;i<matchingResultJsons.size();i++)
            {
                JSONObject matchingResultJson =matchingResultJsons.getJSONObject(i);
                MatchingResult matchingResult = JSONObject.toJavaObject(matchingResultJson,MatchingResult.class);
                totalnumber++;
                if(matchingResult.getMatchScore()>Constant.MATCHTHREHOLD)
                {
                    matchnumber++;
                }
            }
        }
        matchResultDto.setMatchNumber(matchnumber);
        matchResultDto.setTotalNumber(totalnumber);
        System.out.println("total="+totalnumber+"  match="+matchnumber);

//        JSONArray matchingResultJsons = (JSONArray) matchingResultMap.get(groupId);


    }

}
