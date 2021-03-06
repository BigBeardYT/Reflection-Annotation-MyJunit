package com.yc.junit;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ReflectionAndannotation
 * @description:
 * @author: Yt
 * @create: 2021-03-31 19:49
 */
public class MyJunitRunner {

    public static void main(String[] args) throws Exception {
        //因为没有插件，只能先做，class加载
        Class cls = Class.forName("com.yc.MyCalculatorTest");
        //TODO:升级：... 按照maven约定的目录要求来扫描test/java下的单元测试类
        //1.获取这个类中的方法
        Method[] ms = cls.getDeclaredMethods();

        List<Method> testMethods = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;
        Method beforeClassMethod = null;
        Method afterClassMethod = null;

        //2.循环这些方法，判断
        for(Method m:ms){
            System.out.println(m);
            System.out.println(m.isAnnotationPresent(MyTest.class));
            //3.将这些方法分别存好，@Test对应的方法有多个，存到一个集合中，其他注解对应的方法只有一个，直接存
            if(m.isAnnotationPresent(MyTest.class)){
                testMethods.add(m); //添加到集合中
            }
            if(m.isAnnotationPresent(MyBefore.class)){
                beforeMethod = m;
            }
            if(m.isAnnotationPresent(MyAfter.class)){
                afterMethod = m;
            }
            if(m.isAnnotationPresent(MyBeforeClass.class)){
                beforeClassMethod = m;
            }
            if(m.isAnnotationPresent(MyAfterClass.class)){
                afterClassMethod = m;
            }

        }

        //4.按junit的生命周期来调用

        if(testMethods == null|| testMethods.size() <=0){
            throw  new RuntimeException("没有要测试的方法");
        }

        Object o = cls.newInstance();   //实例化测试类
        beforeClassMethod.invoke(o,null);       //@BeforeClass
        for(Method m:testMethods){
            if(beforeMethod!=null){
                beforeMethod.invoke(o,null);    //@Before
            }
            m.invoke(o,null);                   //测试方法
            if(afterMethod !=null){
                afterMethod.invoke(o,null);     //@After
            }
        }
        afterClassMethod.invoke(o,null);        //@AfterClass


    }
}
