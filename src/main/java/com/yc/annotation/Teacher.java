package com.yc.annotation;

/**
 * @program: ReflectionAndannotation
 * @description:
 * @author: Yt
 * @create: 2021-03-29 20:34
 */
@MyHelloWorld(name = "a", age = 30, ins = {"ball"})
public class Teacher {

    @MyHelloWorld(name="b",ins={"game","swin"})
    private String name;


    public String  show( String s){
        return "";
    }
}
