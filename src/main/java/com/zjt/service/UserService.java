package com.zjt.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zjt.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    public User checkLogin(User user);

    public void addUser(List<User> list);
}
