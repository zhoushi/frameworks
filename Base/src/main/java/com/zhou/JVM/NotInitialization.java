package com.zhou.JVM;

/**
 * Created by Administrator on 2017/2/9.
 * 对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过其子类来引用父类中定义的静态字段
 * 只会触发父类的初始化而不会触发子类的初始化
 */
class SuperClass{
    static {
        System.out.println("SuperClass init");
    }
    public static int value = 123;
}
class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init!");
    }
}
public class NotInitialization {

    public static void main(String[] args){
        //通过子类引用父类的静态字段，不会导致子类初始化
        System.out.println(SubClass.value);
    }
}
