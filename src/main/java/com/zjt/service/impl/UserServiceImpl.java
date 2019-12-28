package com.zjt.service.impl;

import com.zjt.mapper.UserMapper;
import com.zjt.pojo.User;
import com.zjt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper um;

    @Override
    public User checkLogin(User user) {

        User user1 = um.getUser(user);

        return user1;
    }

    @Override
    public void addUser(List<User> list) {

    }
}
