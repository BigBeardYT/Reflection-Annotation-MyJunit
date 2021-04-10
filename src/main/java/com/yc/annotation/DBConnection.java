package com.yc.annotation;

import java.lang.annotation.*;

/**
 * @program: ReflectionAndannotation
 * @description:
 * @author: Yt
 * @create: 2021-03-29 21:10
 */
//Target叫元注解，即注解的注解，用来描述一个注解的约束
//value={}  这表示数组Target注解的属性
//@Target(value = {ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Target({ElementType.TYPE})
//这个注解 MyHelloWorld什么时候保留
@Retention(RetentionPolicy.RUNTIME)

public @interface DBConnection {

    //联接数据库的属性
    public String url() default "";

    public String driverClass();

    public String user() default "root";

    public String password()  default "root";
}
