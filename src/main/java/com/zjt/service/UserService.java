package com.zjt.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zjt.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    public User checkLogin(User user);

}
