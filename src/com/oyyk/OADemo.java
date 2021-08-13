package com.oyyk;

public class OADemo {
    public static void main(String[] args) throws InterruptedException {
        Double salary = 2000.00;
        Double money;
        while(true){
            money = calSalary(salary);
            System.out.println(String.format("实际到手工资：{}", money));
            Thread.sleep(1000);
        }
    }

    private static Double calSalary(Double salary){
        return 1.00;
    }
}