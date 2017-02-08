package com.zhou.JVM;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/1/23.
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";

                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];

                    is.read(b);

                    return defineClass(name,b,0,b.length);
                }catch (IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.zhou.JVM.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        //虚拟机中存在两个ClassLoaderTest类，一个是由系统应用程序类加载器加载的，另一个是由我们自定义的类加载器加载的
        System.out.println(obj instanceof com.zhou.JVM.ClassLoaderTest);
    }
}
