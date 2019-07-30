package com.netease.miniadmin.dto;

/**
 * 公用结果类，返回名称和数量
 */
public class CountResult {
    private String field;
    private Integer num;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
