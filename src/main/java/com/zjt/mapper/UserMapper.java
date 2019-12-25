package com.zjt.mapper;

import com.zjt.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    public User getUser(User user);
}
