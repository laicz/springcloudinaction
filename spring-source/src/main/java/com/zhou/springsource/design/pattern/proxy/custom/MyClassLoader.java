/**
 * Date:     2018/7/2623:10
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.design.pattern.proxy.custom;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 代码生成，编译，重新动态load到jvm中
 * 2018/7/26  23:10
 * created by zhoumb
 */
public class MyClassLoader extends ClassLoader {
    private File baseDir;

    public MyClassLoader() {
        String basePath = MyClassLoader.class.getResource("").getPath();
        this.baseDir = new File(basePath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if (baseDir != null) {
            File classFile = new File(baseDir, name.replace("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream fileInputStream = null;
                ByteOutputStream outputStream = null;
                try {
                    fileInputStream = new FileInputStream(classFile);
                    outputStream = new ByteOutputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len = fileInputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, len);
                    }
                    return defineClass(className, outputStream.toByteArray(), 0, outputStream.size());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
        return null;
    }
}
