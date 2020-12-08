package Quiz4.task6;

import java.util.Comparator;

public class DeveloperComparator implements Comparator<Developer> {
    @Override
    public int compare(Developer o1, Developer o2) {
        int comparingEmployee = new EmployeeComparator().compare(o1, o2);
        if (comparingEmployee == 0) {
            return o1.getLevel().compareTo(o2.getLevel());
        }
        return comparingEmployee;
    }
}
