package Quiz9.task2;

import java.time.LocalDate;

public class Util {
    static void review(String className) {
        try {
            Class<?> ourClass = Class.forName(className);
            if (ourClass.isAnnotationPresent(Review.class)) {
                String date = ourClass.getAnnotation(Review.class).date();
                date = date.equals("today") ? LocalDate.now().toString() : date;
                String reviewer = ourClass.getAnnotation(Review.class).reviewer();
                System.out.println("Class " + className + " was reviewed " + date + " by " + reviewer + ".");
            } else {
                System.out.println("Class " + className + " isn't marked as Reviewed");
            }
        } catch (Exception e) {
            System.out.println("Class " + className + " was not found");
        }
    }
}
