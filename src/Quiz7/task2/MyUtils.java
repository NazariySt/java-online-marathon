package Quiz7.task2;

import java.time.LocalDate;

public class MyUtils {
    public static String getDateAfterToday(int years, int month, int days) {
        return LocalDate.now().plusYears(years).plusMonths(month).plusDays(days).toString();
    }

}
