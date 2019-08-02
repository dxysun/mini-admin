package com.netease.miniadmin.dto;

public class MatchResultDto {

    // 用户匹配过的人数
    private Integer totalNumber;


    // 用户匹配上的人数
    private Integer matchNumber;

    public MatchResultDto(Integer totalNumber, Integer matchNumber) {
        this.totalNumber = totalNumber;
        this.matchNumber = matchNumber;
    }

    public MatchResultDto() {
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(Integer matchNumber) {
        this.matchNumber = matchNumber;
    }
}
