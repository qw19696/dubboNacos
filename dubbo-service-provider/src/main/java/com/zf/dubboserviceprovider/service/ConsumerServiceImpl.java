package com.zf.dubboserviceprovider.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zf.dubboserviceprovider.dao.ConsumerDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Consumer;
import service.UserService;

@Service
@DubboService(version = "1.0")
public class ConsumerServiceImpl implements UserService {

    @Autowired
    private ConsumerDao consumerDao;

    @Override
    public Consumer getUser(int id) {
        return consumerDao.selectById(id);
    }

    @Override
    public String countUser(String username, String password) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        if(consumerDao.exists(queryWrapper)){
            return "登陆成功";
        }else {
            return "用户不存在";
        }

    }
}
