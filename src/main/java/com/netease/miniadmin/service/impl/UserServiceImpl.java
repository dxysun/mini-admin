package com.netease.miniadmin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.netease.miniadmin.common.util.Constant;
import com.netease.miniadmin.common.util.RedisUtil;
import com.netease.miniadmin.dto.CountResultDto;
import com.netease.miniadmin.dto.MatchResultDto;
import com.netease.miniadmin.dto.UserMatchDto;
import com.netease.miniadmin.mapper.UserMapper;
import com.netease.miniadmin.model.User;
import com.netease.miniadmin.model.param.MatchingResult;
import com.netease.miniadmin.service.DynamicService;
import com.netease.miniadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    DynamicService dynamicService;

    /**
     * 获取用户总数
     *
     * @return
     */
    @Override
    public Integer getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public Integer selectByCity(String city) {

        return userMapper.selectByCity(city);
    }

    /**
     * 返回地域分布
     *
     * @return
     */
    @Override
    public List<CountResultDto> selectAllCitys() {
        return userMapper.selectAllCitys();
    }

    /**
     * 返回用户年龄分布，20岁以下多少人，20-30岁多少人，30岁以上多少人，未设置年龄多少人
     *
     * @return
     */
    @Override
    public List<CountResultDto> selectAllages() {
        List<CountResultDto> list = userMapper.selectAllages();
        List<CountResultDto> resultList = new ArrayList<CountResultDto>();
        CountResultDto c1 = new CountResultDto("20岁以下", 0);
        CountResultDto c2 = new CountResultDto("20岁-24岁", 0);
        CountResultDto c3 = new CountResultDto("25岁-30岁", 0);
        CountResultDto c4 = new CountResultDto("30岁以上", 0);
        CountResultDto c5 = new CountResultDto("未设置年龄", 0);
        for (CountResultDto c : list) {
            if (c.getField() == null) {
                c5.setNum(c5.getNum() + 1);
                continue;
            }
            if (Integer.valueOf(c.getField()) < 20) {
                c1.setNum(c1.getNum() + 1);
            }
            if (Integer.valueOf(c.getField()) >= 20 && Integer.valueOf(c.getField()) <= 24) {
                c2.setNum(c2.getNum() + 1);
            }
            if (Integer.valueOf(c.getField()) >= 25 && Integer.valueOf(c.getField()) <= 30) {
                c3.setNum(c3.getNum() + 1);
            }
            if (Integer.valueOf(c.getField()) > 30) {
                c4.setNum(c4.getNum() + 1);
            }

        }
        resultList.add(c1);
        resultList.add(c2);
        resultList.add(c3);
        resultList.add(c4);
        resultList.add(c5);
        return resultList;
    }

    /**
     * 返回性别人数
     *
     * @return
     */
    @Override
    public List<CountResultDto> selectAllGenders() {
        List<CountResultDto> countResultDtos = userMapper.selectAllGenders();
        for (CountResultDto c : countResultDtos) {
            if (c.getField() == null) {
                c.setField("未知");
                continue;
            } else if (c.getField().equals("1")) {
                c.setField("男");
            } else {
                c.setField("女");
            }
        }
        return countResultDtos;
    }

    /**
     * 返回性别比率
     *
     * @return
     */
    @Override
    public List<CountResultDto> selectGenderRatio() {
        List<CountResultDto> countResultDtos = selectAllGenders();
        List<CountResultDto> resultList = new ArrayList<CountResultDto>();
        CountResultDto boy = new CountResultDto();
        boy.setField("男");
        CountResultDto girl = new CountResultDto();
        girl.setField("女");
        CountResultDto unknown = new CountResultDto();
        unknown.setField("未知");
        int sum = getUserCount();
        for (CountResultDto c : countResultDtos) {
            int ratio = c.getNum() * 100 / sum;
            if (c.getField().equals(boy.getField())) {
                boy.setNum(ratio);
            }
            if (c.getField().equals(girl.getField())) {
                girl.setNum(ratio);
            }
        }
        unknown.setNum(100 - boy.getNum() - girl.getNum());
        resultList.add(boy);
        resultList.add(girl);
        resultList.add(unknown);
        return resultList;
    }

    /**
     * 返回学生党和工作党人数
     * @return
     */
    @Override
    public List<CountResultDto> selectWorkStatus() {
        List<CountResultDto> countResultDtos = userMapper.selectWorkStatus();
        for (CountResultDto c : countResultDtos) {
            if (c.getField() == null) {
                c.setField("未知");
            } else if (c.getField().equals("1")) {
                c.setField("工作党");
            } else {
                c.setField("学生党");
            }
        }
        return countResultDtos;
    }

    /**
     * 返回学生党，工作党人数比例
     * @return
     */
    @Override
    public List<CountResultDto> selectWorkStatusRatio() {
        List<CountResultDto> countResultDtos = selectWorkStatus();
        List<CountResultDto> resultList = new ArrayList<CountResultDto>();
        CountResultDto worker = new CountResultDto();
        worker.setField("工作党");
        CountResultDto student = new CountResultDto();
        student.setField("学生党");
        int sum = getUserCount();
        for (CountResultDto c : countResultDtos) {
            int ratio = c.getNum() * 100 / sum;
            if (c.getField().equals(worker.getField())) {
                worker.setNum(ratio);
            }
        }
        student.setNum(100 - worker.getNum());
        resultList.add(worker);
        resultList.add(student);
        return resultList;
    }

    @Override
    public Page<User> getAllUsers() {
        return userMapper.selectAllUser();
    }


    // 获取该用户匹配过 和匹配上的人数
    @Override
    public MatchResultDto getMatcherNumber(String openId) {
        MatchResultDto matchResultDto = new MatchResultDto(0, 0);
        int totalnumber = 0;
        int matchnumber = 0;
        String mapJsonString = (String) redisUtil.get(openId);
        if (mapJsonString == null) {
            return matchResultDto;
        }
        JSONObject matchingResultMap = JSON.parseObject(mapJsonString);
        Set<String> groupset = matchingResultMap.keySet();

        for(String s:groupset)
        {
            JSONArray matchingResultJsons = (JSONArray) matchingResultMap.get(s);
            for(int i=0;i<matchingResultJsons.size();i++)
            {
                JSONObject matchingResultJson =matchingResultJsons.getJSONObject(i);
                MatchingResult matchingResult = JSONObject.toJavaObject(matchingResultJson,MatchingResult.class);
                totalnumber++;
                if(matchingResult.getMatchScore()> Constant.MATCHTHREHOLD)
                {
                    matchnumber++;
                }
            }
        }
        matchResultDto.setMatchNumber(matchnumber);
        matchResultDto.setTotalNumber(totalnumber);

        return matchResultDto;
    }

    @Override
    public List<UserMatchDto> getUserMatch() {
        List<User> userList = userMapper.selectAllUser();
        List<UserMatchDto> userMatchDtoList = new ArrayList<>();
        List<CountResultDto> countResultDtoList = dynamicService.getDynamicsNum();
        for (int i = 0; i < userList.size(); i++) {
            UserMatchDto userMatchDto = new UserMatchDto();
            userMatchDto.setId(userList.get(i).getId());
            userMatchDto.setOpenId(userMapper.selectOpenIdById(userList.get(i).getId()));
            for(int j=0;j<countResultDtoList.size();j++){
                if(countResultDtoList.get(j).getField().equals(userMatchDto.getOpenId())){
                    userMatchDto.setDynamicCount(countResultDtoList.get(j).getNum());
                }
            }
            userMatchDto.setNickName(userList.get(i).getNickName());
            MatchResultDto matchResultDto = getMatcherNumber(userMatchDto.getOpenId());
            userMatchDto.setMatchResultDto(matchResultDto);
            double matchRatio = (double)matchResultDto.getMatchNumber()/matchResultDto.getTotalNumber();
            if(matchResultDto.getTotalNumber()==0){
                matchRatio = 0;
            }
            userMatchDto.setMatchRatio(matchRatio);
            userMatchDtoList.add(userMatchDto);
        }
        return userMatchDtoList;

    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUserById(id);
    }
}
