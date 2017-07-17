package com.aop.annotation;

import java.lang.annotation.*;

/**
 * Created by zjl on 2017/7/17.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyCache {
    public String value() default "";
}
