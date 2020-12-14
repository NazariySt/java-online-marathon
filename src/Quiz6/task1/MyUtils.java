package Quiz6.task1;

import java.util.function.Predicate;

public class MyUtils {

    public static int getCount(int[] array, Predicate<Integer> predicate) {
        int value = 0;
        for (int i : array) {
            if (predicate.test(i)) {
                value++;
            }
        }
        return value;
    }
}
