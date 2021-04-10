package com.yc.reflection;

import com.yc.Showable;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: ReflectionAndAnnotation
 * @description:
 * @author: Yt
 * @create: 2021-03-29 18:40
 */
public class Test01 {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入路径类:");
            String path = sc.nextLine();
            System.out.println("待加载的类为:"+path);

            Class c = Class.forName(path);
            String name = c.getName();
            System.out.println(name);

            //获取方法
            Method[] ms = c.getDeclaredMethods();


            Object o = c.newInstance(); //无参构造方法
            if(o instanceof Showable){
                Showable p = (Showable) o;
                p.show();
            }

            //利用发射调用某个方法 适合j2EE中的规范化方法调用场景：setXXX  getXxx()
            System.out.println("++++++++++++++++++++++++++++++++");


            Map<String,String> pMap = new HashMap<String ,String>();
            pMap.put("name","张三");
            pMap.put("age",40+"");

            Object oo = setValues(pMap,c);
            System.out.println(oo.toString());
        }


    }

    /**
     * 反射功能模块：将Map中保存的 属性值存到  cls对应的对象中，注意已知
     */
    public static Object setValues(Map<String,String> map , Class cls) throws Exception {
        Object o = null;
        o = cls.newInstance();

        Method[] ms = cls.getDeclaredMethods();
        if( ms!=null&& ms.length>0){
            for(Method m:ms){
                //只有set开头的方法才激活
                if(m.getName().startsWith("set")){  //setName()  ->  name
                    String mName = m.getName();
                    String fName = mName.substring(3).toLowerCase();
                    String value = map.get(fName);
                    if("Integer".equalsIgnoreCase(m.getParameterTypes()[0].getTypeName()) ||
                            "int".equalsIgnoreCase(m.getParameterTypes()[0].getTypeName()) ){
                        m.invoke(o,Integer.parseInt(value));    //调用set方法，设置值
                    }else{
                        m.invoke( o,value);
                    }

                }
            }
        }
        return o;
    }
}
