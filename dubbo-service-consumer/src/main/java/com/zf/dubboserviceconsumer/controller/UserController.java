package com.zf.dubboserviceconsumer.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Consumer;
import pojo.Song;
import service.SongService;
import service.UserService;

import java.util.List;

@RestController
public class UserController {

    @DubboReference(check = false,version = "1.0")
    private SongService songService;

    @DubboReference(check = false,version = "1.0")
    private UserService userService;

    @GetMapping("/getUser")
    public Consumer getUser(@Param("id") int id){
        return userService.getUser(id);
    }

    @GetMapping("/test")
    public String test(@Param("username") String username,@Param("password") String password){
        return userService.countUser(username,password);
    }

    @GetMapping("/songId")
    public Song getSong(@Param("id") int id){
        return songService.getSong(id);
    }

    @GetMapping("/song")
    public List<Song> getAllSong(){
        return songService.getAllSong();
    }

}
