package Quiz4.task6;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int comparingPerson = new PersonComparator().compare(o1, o2);
        if (comparingPerson == 0) {
            if (o1.getSalary() == o2.getSalary()) {
                return 0;
            }
            if (o2.getSalary() > o2.getSalary()) {
                return 1;
            }
            return -1;
        }
        return comparingPerson;
    }
}
