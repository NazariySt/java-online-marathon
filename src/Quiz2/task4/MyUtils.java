package Quiz2.task4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    public List<Employee> largestEmployees(List<Employee> workers) {
        List<Employee> employees = new ArrayList<>();
        List<Manager> managers = new ArrayList<>();

        int maxEmpExp = 0;
        BigDecimal maxEmpPay = new BigDecimal(0);

        int maxManExp = 0;
        BigDecimal maxManPay = new BigDecimal(0);

        for (Employee employee : workers){
            if(employee instanceof Manager && !managers.contains(employee)){
                managers.add((Manager) employee);
                if(employee.getExperience() > maxManExp){
                    maxManExp = employee.getExperience();
                }
                if(employee.getPayment().compareTo(maxManPay) == 1){
                    maxManPay = employee.getPayment();
                }
            }

            if(employee != null && !(employee instanceof Manager) && !employees.contains(employee)) {
                employees.add(employee);
                if(employee.getExperience() > maxEmpExp){
                    maxEmpExp = employee.getExperience();
                }
                if(employee.getPayment().compareTo(maxEmpPay) == 1){
                    maxEmpPay = employee.getPayment();
                }
            }
        }

        List<Employee> lastArray = new ArrayList<>();
        for(Employee employee : workers){
            if(employee instanceof Manager && !lastArray.contains(employee)){
                if(employee.getExperience() == maxManExp || employee.getPayment().compareTo(maxManPay) == 0) {
                    lastArray.add(employee);
                }
            }

            if(employee != null && !(employee instanceof Manager) && !lastArray.contains(employee)) {
                if(employee.getExperience() == maxEmpExp || employee.getPayment().compareTo(maxEmpPay) == 0){
                    lastArray.add(employee);
                }
            }
        }

        return lastArray;
    }

    public static void main(String[] args){
        List<Employee> originList = new ArrayList<>();

        originList.add(new Employee("Ivan", 10, new BigDecimal("3000.00")));
        originList.add(new Manager("Petro", 9, new BigDecimal("3000.00"), 1.5));
        originList.add(new Employee("Stepan", 8, new BigDecimal("4000.00")));
        originList.add(new Employee("Andriy", 7, new BigDecimal("3500.00")));
        originList.add(new Employee("Ihor",5, new BigDecimal("3500.00")));
        originList.add(new Manager("Vasyl", 8, new BigDecimal("2000.00"), 2.0));

        List<Employee> lastList = new MyUtils().largestEmployees(originList);
        for(Employee emp : lastList) {
            System.out.println(emp.getName() + " " + emp.getExperience() + " " + emp.getPayment());
        }
    }
}
