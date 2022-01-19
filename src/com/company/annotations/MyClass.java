package com.company.annotations;

import java.lang.reflect.Method;

public class MyClass {

    @MyAnnotation(value =  10)
    public  void sayHello(){
        System.out.println("my custom annotation");
    }

    public static void main(String args[]) throws Exception{
        MyClass h = new MyClass();
        Method methodVal = h.getClass().getMethod("sayHello");

        MyAnnotation myAnnotation = methodVal.getAnnotation(MyAnnotation.class);
        System.out.println("Value is : " + myAnnotation.value());

    }
}
