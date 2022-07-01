package com.zf.dubboserviceconsumer.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Consumer;
import service.UserService;

@RestController
public class UserController {

    @DubboReference(check = false,version = "1.0")
    private UserService userService;

    @GetMapping("/getUser")
    public Consumer getUser(@Param("id") int id){
        return userService.getUser(id);
    }

}
