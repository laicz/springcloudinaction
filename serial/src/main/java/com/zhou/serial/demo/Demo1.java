/**
 * Date:     2018/7/2422:41
 * AUTHOR:   Administrator
 */
package com.zhou.serial.demo;

import com.alibaba.fastjson.JSON;
import com.zhou.serial.entity.User;

import java.io.*;

/**
 * 2018/7/24  22:41
 * created by zhoumb
 */
public class Demo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setUserName("z周明");
        user.setUserId("daegfasf");
        user.setAge(100);
        //定义一个字节数组
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //对象输出流
        ObjectOutputStream outputStream = new ObjectOutputStream(os);
        //将对象写入到字节数组输出，进行序列化
        outputStream.writeObject(user);
        byte[] bytes = os.toByteArray();

        //字节数组输入流
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        User user1 = (User) objectInputStream.readObject();
        System.out.println(JSON.toJSONString(user1));
    }

}
