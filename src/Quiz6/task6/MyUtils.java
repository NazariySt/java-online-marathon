package Quiz6.task6;

import java.util.List;
import java.util.function.Predicate;

public class MyUtils {
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        int min = 0;
        for (Integer n : numbers) {
            if (n > min && pr.test(n)) {
                min = n;
            }
        }
        return min;
    }
}
