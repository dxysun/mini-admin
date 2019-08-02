package com.netease.miniadmin.dto;

public class EchartResult {

    private Integer value;

    private String name;

    public EchartResult(){}

    public EchartResult(String name, Integer value){
        this.name = name;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
