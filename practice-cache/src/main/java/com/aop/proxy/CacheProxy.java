package com.aop.proxy;

import com.aop.parse.CacheParse;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by zjl on 2017/7/17.
 */
public class CacheProxy implements MethodInterceptor{
    private  Enhancer enhancer = new Enhancer();
    private Logger logger = LoggerFactory.getLogger(CacheProxy.class);

    public  Object getProxy(Class clazz){
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = CacheParse.parseAnnotation(o, method, objects, methodProxy);
        return  result;

    }
}
