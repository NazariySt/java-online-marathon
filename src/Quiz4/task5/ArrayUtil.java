package Quiz4.task5;

public class ArrayUtil {
    public static double averageValue(Array<? extends Number> arr) {
        double summ = 0;
        for (int i = 0; i < arr.length(); i++) {
            summ += arr.get(i).doubleValue();
        }
        return summ / arr.length();

    }
}
