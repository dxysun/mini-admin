package com.netease.miniadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.netease.miniadmin.service.impl","com.netease.miniadmin.service.mapper","com.netease.miniadmin.service.config"})
public class MiniAdminApplication {

    public static void main(String[] args) {
        System.out.println("start");
        SpringApplication.run(MiniAdminApplication.class, args);
    }

}
