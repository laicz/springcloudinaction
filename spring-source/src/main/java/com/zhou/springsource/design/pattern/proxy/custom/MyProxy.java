/**
 * Date:     2018/7/2623:08
 * AUTHOR:   Administrator
 */
package com.zhou.springsource.design.pattern.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 自己写代理类
 * 目的：生成代理对象代码
 * 2018/7/26  23:08
 * created by zhoumb
 */
public class MyProxy {

    private static final String LN = "\r\n";

    public static Object newProxyInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler h)
            throws IllegalArgumentException {

        //生成源代码
        String proxySrc = generateSrc(interfaces);
        //将生成的源代码输出到磁盘中，保存为java文件
        String filePath = MyProxy.class.getResource("").getPath();
        File f = new File(filePath + "$Proxy0.java");
        try (FileWriter fileWriter = new FileWriter(f)) {
            fileWriter.write(proxySrc);
            fileWriter.flush();

            //编译成class字节码文件
            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager standardFileManager = javaCompiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterator = standardFileManager.getJavaFileObjects(f);

            //将class文件中的对象  动态加载到jvm中
            JavaCompiler.CompilationTask task = javaCompiler.getTask(null, standardFileManager, null, null, null, iterator);
            task.call();
            standardFileManager.close();

            //返回被代理对象
            Class<?> proxyClass = classLoader.findClass("$Proxy0");
            Constructor<?> constructor = proxyClass.getConstructor(MyInvocationHandler.class);
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder src = new StringBuilder();
        src.append("package com.zhou.springsource.design.pattern.proxy.custom;").append(LN);
        src.append("import java.lang.reflect.Method;").append(LN);
        src.append("public class $Proxy0 implements ").append(interfaces[0].getName()).append("{").append(LN);

        //拼凑属性
        src.append("MyInvocationHandler h;").append(LN);
        //拼凑构造函数
        src.append("public $Proxy0(MyInvocationHandler h) {").append(LN);
        src.append("this.h = h;").append(LN);
        src.append("}").append(LN);

        //拼凑方法
        for (Method method : interfaces[0].getMethods()) {
            src.append("public ").append(method.getReturnType()).append(" ").append(method.getName()).append("()  throws Throwable {").append(LN);
            src.append("Method m = ").append(interfaces[0].getName()).append(".class.getMethod(\"").append(method.getName()).append("\",new Class[]{});").append(LN);
            src.append("this.h.invoke(this,m,null);").append(LN);
            src.append("}").append(LN);
        }

        src.append("}");
        return src.toString();
    }

}
