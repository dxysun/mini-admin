package com.netease.miniadmin.dto;

public class EchartResultDto {

    private Integer value;

    private String name;

    public EchartResultDto(){}

    public EchartResultDto(String name, Integer value){
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
