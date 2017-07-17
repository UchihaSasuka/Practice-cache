package com.aop.service;

import com.aop.annotation.MyCache;
import com.aop.bean.User;

/**
 * Created by zjl on 2017/7/17.
 */
public class ServiceImpl {
    @MyCache("name")
    public User getUser(String name){
        return new User(name);
    }
}
