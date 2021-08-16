package com.oyyk;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import java.io.File;
import java.io.FileInputStream;
import java.security.SecureClassLoader;

/**
 * 从.myclass文件中加载对象
 */
public class SalaryClassLoader extends SecureClassLoader {
    private String classPath;
    public SalaryClassLoader(String classPath){
        this.classPath = classPath;
    }

    // 需要实现从.myclass文件中加载
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String filePath = this.classPath + name.replace(".", "\\").concat(".myclass");
        FileInputStream fis;
        byte[] b;
        ByteArrayBuffer ba = new ByteArrayBuffer();
        int code;
        try {
            fis = new FileInputStream(new File(filePath));
            code = fis.read();
            while((code = fis.read()) != -1){
                ba.write(code);
            }
            b = ba.toByteArray();
            return this.defineClass(name, b, 0, b.length);
        } catch (Exception e){
         throw new ClassNotFoundException("自定义文件不存在");
        }
//        return super.findClass(name);
    }
}
