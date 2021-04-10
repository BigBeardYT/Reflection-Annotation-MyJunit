package com.yc.annotation;

import java.lang.annotation.*;

/**
 * @program: ReflectionAndannotation
 * @description:
 * @author: Yt
 * @create: 2021-03-29 20:34
 */
//Target叫元注解，即注解的注解，用来描述一个注解的约束
    //value={}  这表示数组Target注解的属性
//@Target(value = {ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
//这个注解 MyHelloWorld什么时候保留
@Retention(RetentionPolicy.SOURCE)

@Documented     //生成的javadoc文档中是否保留这个注解
@Inherited      //子类是否可以继承
public @interface MyHelloWorld {

    public String name();   //这个时 M'y'helloWorld注解一定要有的属性值

    public int age() default 30;

    public String[] ins();
}
