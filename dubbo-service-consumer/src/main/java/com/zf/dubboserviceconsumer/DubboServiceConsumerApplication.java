package com.zf.dubboserviceconsumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboServiceConsumerApplication.class, args);
    }

}
