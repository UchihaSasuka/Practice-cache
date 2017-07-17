package com.aop.test;

import com.aop.proxy.CacheProxy;
import com.aop.service.ServiceImpl;

/**
 * Created by zjl on 2017/7/17.
 */
public class CacheTest {
    public static void main(String[] args) {
        CacheProxy cacheProxy = new CacheProxy();
        ServiceImpl service = (ServiceImpl) cacheProxy.getProxy(ServiceImpl.class);
        service.getUser("lp");
        service.getUser("lp");
    }
}
