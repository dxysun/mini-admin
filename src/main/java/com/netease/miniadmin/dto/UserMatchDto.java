package com.netease.miniadmin.dto;

public class UserMatchDto {
    Integer id;
    String openId;
    String nickName;
    MatchResultDto matchResultDto;
    String matchRatio;
    Integer dynamicCount;

    public Integer getDynamicCount() {
        return dynamicCount;
    }

    public void setDynamicCount(Integer dynamicCount) {
        this.dynamicCount = dynamicCount;
    }

    public String getMatchRatio() {
        return matchRatio;
    }

    public void setMatchRatio(String matchRatio) {
        this.matchRatio = matchRatio;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public MatchResultDto getMatchResultDto() {
        return matchResultDto;
    }

    public void setMatchResultDto(MatchResultDto matchResultDto) {
        this.matchResultDto = matchResultDto;
    }

    public UserMatchDto() {
        super();
    }
}
