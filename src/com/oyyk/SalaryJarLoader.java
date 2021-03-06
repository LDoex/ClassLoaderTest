package com.oyyk;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.SecureClassLoader;

/**
 * 实现从jar包中找到class文件来加载类
 */
public class SalaryJarLoader extends SecureClassLoader {
    //用一个jar包模拟整个工程
    private String jarFile;

    public SalaryJarLoader(String jarFile){
        this.jarFile = jarFile;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.startsWith("com.oyyk")){
            return this.findClass(name);
        }
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("重新加载类："+name);
//        String filePath = this.classPath + name.replace(".", "\\").concat(".myclass");
        String classPath = name.replace(".", "/").concat(".class");
        InputStream inputStream;
        URL fileUrl;
        byte[] b;
        ByteArrayBuffer ba = new ByteArrayBuffer();
        int code;
        try {
            fileUrl = new URL("jar:file:\\" + this.jarFile + "!/" + classPath);
            inputStream = fileUrl.openStream();

            while((code = inputStream.read()) != -1){
                ba.write(code);
            }
            b = ba.toByteArray();
            return this.defineClass(name, b, 0, b.length);
        } catch (Exception e){
            System.out.println("文件还未复制完");
            return null;
        }
        //return super.findClass(name);
    }
}
