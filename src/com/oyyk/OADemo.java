package com.oyyk;

public class OADemo {
    public static void main(String[] args) throws Exception {
        Double salary = 2000.00;
        Double money;
        while(true){
            money = calSalary(salary);
            System.out.println("实际到手工资：" + money);
            Thread.sleep(1000);
        }
    }

    private static Double calSalary(Double salary){
        SalaryCaler caler = new SalaryCaler();
        return caler.cal(salary);
    }
}