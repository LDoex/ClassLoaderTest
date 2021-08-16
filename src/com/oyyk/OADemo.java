package com.oyyk;

import java.net.URL;
import java.net.URLClassLoader;

public class OADemo {
    public static void main(String[] args) throws Exception {
        Double salary = 2000.00;
        Double money;
//        URL jarPath = new URL("file:D:\\:lib\\SalaryCaler.jar");
//        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{jarPath});
        String curPath = System.getProperty("user.dir");
//        SalaryClassLoader salaryClassLoader = new SalaryClassLoader(curPath + "\\out\\production\\ClassLoaderTest\\");

        SalaryJarLoader salaryJarLoader = new SalaryJarLoader("D:\\lib\\SalaryCaler.jar");
        while(true){
            money = calSalary(salary, salaryJarLoader );
            System.out.println("实际到手工资：" + money);
            Thread.sleep(1000);
        }
    }

    private static Double calSalary(Double salary, ClassLoader classLoader) throws Exception {
//        SalaryCaler caler = new SalaryCaler();
//        return caler.cal(salary);
        Class<?> clazz = classLoader.loadClass("com.oyyk.SalaryCaler");
        Object object = clazz.newInstance();
        return (Double) clazz.getMethod("cal", Double.class).invoke(object, salary);
    }
}