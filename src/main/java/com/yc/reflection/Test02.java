package com.yc.reflection;

/**
 * @program: ReflectionAndannotation
 * @description:
 * @author: Yt
 * @create: 2021-03-31 21:10
 */
public class Test02 {

    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("com.yc.reflection.Student");

//        Method [] ms = cls.getDeclaredMethods();
//        for(Method m: ms){
//            System.out.println(m);
//        }


        Student s = (Student) cls.newInstance();


        Student s1 = new Student();

        System.out.println(s1);
    }
}
