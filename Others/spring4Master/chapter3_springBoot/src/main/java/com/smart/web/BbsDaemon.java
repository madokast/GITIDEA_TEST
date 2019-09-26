package com.smart.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@EnableAutoConfiguration
public class BbsDaemon {
    @RequestMapping("/")
    public String index(){
        return "欢迎光临小春论坛!"+new Date();
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(BbsDaemon.class,args);
    }
}
