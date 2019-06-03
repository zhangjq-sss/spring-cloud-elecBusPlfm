package com.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PocLog {


    String  value() default "";

    /**
     * 判断是否是维护平台操作
     * @return
     */
    boolean  userLog() default false;
}

