package firstQuiz;

public class Employee {
    public String fullName;
    public float salary;

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        emp1.fullName = "Nazar";
        emp1.salary = 1.0f;
        emp2.fullName = "Yura";
        emp2.salary = 2.0f;
        Employee[] employees = new Employee[2];
        employees[0] = emp1;
        employees[1] = emp2;
        String employeesInfo = "";
        for (int i = 0; i < employees.length; i++) {
            employeesInfo += String.format("{fullName: \"%s\", salary: %s}, ", employees[i].fullName, employees[i].salary);

        }
        //  System.out.println(Arrays.toString(employees));
        employeesInfo = "[" + employeesInfo + "]";
        StringBuffer stringBuffer = new StringBuffer(employeesInfo);
        stringBuffer.delete(66, 68);
        employeesInfo = stringBuffer.toString();
        System.out.println(employeesInfo);

    }
}
