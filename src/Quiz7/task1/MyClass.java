package Quiz7.task1;

import java.time.LocalDate;
import java.time.Month;

public class MyClass {
    public static boolean isLeapYear(int year) {
        return LocalDate.of(year, Month.APRIL, 10).isLeapYear();
    }
}
