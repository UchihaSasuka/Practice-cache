package com.aop.parse;


import com.aop.annotation.MyCache;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by zjl on 2017/7/17.
 */
public class CacheParse {
    private static Logger logger = LoggerFactory.getLogger(CacheParse.class);

    private static HashMap<String, HashMap<String, Object>> bigMap = new HashMap<>();

    public static Object parseAnnotation(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
       Object object=null;

       if(method.isAnnotationPresent(MyCache.class)) {
           MyCache mycache = method.getDeclaredAnnotation(MyCache.class);
           String value = mycache.value();
           HashMap<String, Object> cacheValue = bigMap.get(value);
           String name = (String) objects[0];
           if(cacheValue != null){
               object = cacheValue.get(name);
               if(object != null){
                   logger.info("load from cache");
                   return object;
               }
           }
           logger.info("load from db");
           object = methodProxy.invokeSuper(o, objects);
           setCache(value, name, object, cacheValue);
       }
       return object;
    }

    private static void setCache(String value, String name, Object object, HashMap<String, Object> cacheMap){
        if(cacheMap ==null){
            cacheMap = new HashMap();
        }
        cacheMap.put(name, object);
        bigMap.put(value, cacheMap);
    }

}
