/**
 * Date:     2018/7/2523:20
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.design.pattern.proxy.legacy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * 2018/7/25  23:20
 * created by zhoumb
 */
public class ProxyTest {
    public static void main(String[] args) throws Throwable {
//        new Zhangsan().findLove();
        Person person = (Person) new Meipo().getInstance(new Zhangsan());
        person.findLove();
        System.out.println(person.getClass());

        //生成字节码文件(实质是二进制文件)
        byte[] data = ProxyGenerator.generateProxyClass("$Prosy0", new Class[]{Person.class});
        FileOutputStream fileOutputStream = new FileOutputStream("G:\\gupao\\$Proxy0.class");
        fileOutputStream.write(data);
        fileOutputStream.close();
    }
}
