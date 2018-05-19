package com.flyer.zww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import  org.springframework.boot.autoconfigure.EnableAutoConfiguration;


/**
 * @Auther: gavin
 * @Date: 2018-05-11 21:28
 * @Description: 程序启动入口
 */

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
