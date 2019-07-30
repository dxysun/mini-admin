package com.netease.miniadmin.model.param;

import com.netease.miniadmin.model.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ChenShaoJie
 * @Date 2019-07-19 15:57
 * 用户匹配结果类
 */
public class MatchingResult implements Comparable<MatchingResult> {
    private String selfOpenId;  //使用者的openId
    private String selfNickName;     //使用者的昵称
    private String selfAvatarUrl;   //使用者头像Url
    private String targetNickName;  //匹配目标的昵称
    private String targetAvatarUrl;     //匹配目标的头像Url
    private String targetOpenId;    //匹配目标的openId
    private String groupId; //匹配的群组Id
    private String groupName; //匹配的群名称
    private List<Integer> qualifiedSelfTagIds; //对方符合我条件的标签Id
    private List<Integer> qualifiedTargetTagIds; //我符合对方的标签Id
    private List<Tag> qualifiedSelfTags; //对方符合我条件的标签
    private List<Tag> qualifiedTargetTags; //我符合对方的标签
    private List<String> qualifiedSelfSpecialRequires; //对方符合我的特殊数值的需求
    private List<String> qualifiedTargetSpecialRequires; //我符合对方的特殊数值的需求

    private double matchScore; //匹配分数

    public MatchingResult() {
        qualifiedSelfTagIds = new ArrayList<>();
        qualifiedTargetTagIds = new ArrayList<>();
        qualifiedSelfTags = new ArrayList<>();
        qualifiedTargetTags = new ArrayList<>();
        qualifiedSelfSpecialRequires = new ArrayList<>();
        qualifiedTargetSpecialRequires = new ArrayList<>();
    }

    public String getSelfOpenId() {
        return selfOpenId;
    }

    public void setSelfOpenId(String selfOpenId) {
        this.selfOpenId = selfOpenId;
    }

    public String getSelfNickName() {
        return selfNickName;
    }

    public void setSelfNickName(String selfNickName) {
        this.selfNickName = selfNickName;
    }

    public String getSelfAvatarUrl() {
        return selfAvatarUrl;
    }

    public void setSelfAvatarUrl(String selfAvatarUrl) {
        this.selfAvatarUrl = selfAvatarUrl;
    }

    public String getTargetNickName() {
        return targetNickName;
    }

    public void setTargetNickName(String targetNickName) {
        this.targetNickName = targetNickName;
    }

    public String getTargetAvatarUrl() {
        return targetAvatarUrl;
    }

    public void setTargetAvatarUrl(String targetAvatarUrl) {
        this.targetAvatarUrl = targetAvatarUrl;
    }

    public String getTargetOpenId() {
        return targetOpenId;
    }

    public void setTargetOpenId(String targetOpenId) {
        this.targetOpenId = targetOpenId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    public List<String> getQualifiedSelfSpecialRequires() {
        return qualifiedSelfSpecialRequires;
    }

    public void setQualifiedSelfSpecialRequires(List<String> qualifiedSelfSpecialRequires) {
        this.qualifiedSelfSpecialRequires = qualifiedSelfSpecialRequires;
    }

    public double getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(double matchScore) {
        this.matchScore = matchScore;
    }

    public List<Integer> getQualifiedSelfTagIds() {
        return qualifiedSelfTagIds;
    }

    public void setQualifiedSelfTagIds(List<Integer> qualifiedSelfTagIds) {
        this.qualifiedSelfTagIds = qualifiedSelfTagIds;
    }

    public List<Integer> getQualifiedTargetTagIds() {
        return qualifiedTargetTagIds;
    }

    public void setQualifiedTargetTagIds(List<Integer> qualifiedTargetTagIds) {
        this.qualifiedTargetTagIds = qualifiedTargetTagIds;
    }

    public List<String> getQualifiedTargetSpecialRequires() {
        return qualifiedTargetSpecialRequires;
    }

    public void setQualifiedTargetSpecialRequires(List<String> qualifiedTargetSpecialRequires) {
        this.qualifiedTargetSpecialRequires = qualifiedTargetSpecialRequires;
    }

    public List<Tag> getQualifiedSelfTags() {
        return qualifiedSelfTags;
    }

    public void setQualifiedSelfTags(List<Tag> qualifiedSelfTags) {
        this.qualifiedSelfTags = qualifiedSelfTags;
    }

    public List<Tag> getQualifiedTargetTags() {
        return qualifiedTargetTags;
    }

    public void setQualifiedTargetTags(List<Tag> qualifiedTargetTags) {
        this.qualifiedTargetTags = qualifiedTargetTags;
    }


    @Override
    public int compareTo(MatchingResult o) {
        if(this.getTargetOpenId().equals(o.getTargetOpenId()))
        {
            return 0;
        }
        else
        {
            if(this.getMatchScore()>=o.getMatchScore())
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }

    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        MatchingResult that = (MatchingResult) o;
//        return targetOpenId.equals(that.targetOpenId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(targetOpenId);
//    }


}
