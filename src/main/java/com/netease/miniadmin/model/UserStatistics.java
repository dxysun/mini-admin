package com.netease.miniadmin.model;

/**
 * @author XiaBin
 * @date 2019-08-08 13:43
 * 统计不同地区的人数
 */
public class UserStatistics {
    private String name;
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
