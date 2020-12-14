package Quiz6.task2;

import java.util.function.Consumer;

public class App {
    static Consumer<double[]> cons = (double[] array) -> {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 2) {
                array[i] = array[i] * 0.8;
            } else {
                array[i] = array[i] * 0.9;
            }
        }
    };

    public static double[] getChanged(double[] ourArray, Consumer<double[]> consumer) {
        double[] modifyArray = new double[ourArray.length];
        for (int i = 0; i < modifyArray.length; i++) {
            modifyArray[i] = ourArray[i];
        }
        consumer.accept(modifyArray);
        return modifyArray;
    }
}
