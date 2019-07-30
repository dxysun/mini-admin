package com.netease.miniadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniAdminApplication {

    public static void main(String[] args) {
        System.out.println("start");
        SpringApplication.run(MiniAdminApplication.class, args);
    }

}
