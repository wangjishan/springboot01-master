package com.example.service;

import com.example.dao.UserMapper;
import com.example.model.OrdersExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2017/4/24.
 */


@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;


    public UserService() {
        System.out.println("UserService实例化");
    }


    public List<OrdersExt> findOrderAndUser4() {
        System.out.println("UserService实例化====");
        return userMapper.findOrderAndUser4();
    }



}
