package com.cheng.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chengwei
 * @date 2019-08-26 15:06
 */
@SpringBootApplication
@ComponentScan({"com.cwhlj.common.*","com.cheng.springboot.*"})
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
