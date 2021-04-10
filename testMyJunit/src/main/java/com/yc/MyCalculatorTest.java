package com.yc;

import com.yc.junit.*;

/**
 * @program: ReflectionAndannotation
 * @description:
 * @author: Yt
 * @create: 2021-03-31 19:43
 */
public class MyCalculatorTest {

    //private Calculator cal;//待测试的单元

    @MyBeforeClass
    public static void bc(){
        System.out.println("beforeclass");
    }

    @MyBefore
    public void setUp() {
        System.out.println("before");
    }
    @MyAfter
    public void tearDown() {
        System.out.println("after");
    }

    @MyAfterClass
    public static void ac(){
        System.out.println("Afterclass");
    }

    @MyTest
    public void add() {
        System.out.println("add测试:");

    }

    @MyTest
    public void sub() {
        System.out.println("sub测试:");
    }
}
