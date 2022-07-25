package com.zf.dubboserviceconsumer.controller;

import common.Result;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.ibatis.annotations.Param;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Consumer;
import pojo.Song;
import service.SongService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;


import java.util.List;

@RestController
public class UserController {

    @DubboReference(check = false,version = "1.0")
    private SongService songService;

    @DubboReference(check = false,version = "1.0")
    private UserService userService;

    @GetMapping("/getUser")
    public Result<Consumer> getUser( @Param("id")int id, HttpServletRequest req){
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
        return Result.success(userService.getUser(id));
    }

    @GetMapping("/test")
    public String test(@Param("username") String username,@Param("password") String password){
        return userService.countUser(username,password);
    }

    @GetMapping("/songId")
    public Result<Song> getSong( @Param("id") int id){
        return Result.success(songService.getSong(id));
    }

    @GetMapping("/song")
    public Result<List<Song>> getAllSong(){
        return Result.success(songService.getAllSong());
    }

}
