package Quiz2.task5;

import java.util.List;

public class MyUtils {
    public double sumPerimeter(List<Rectang> firures) {
        double summ = 0;
        for (Rectang rectang : firures) {
            if (rectang != null) {
                summ += rectang.getPerimeter();
            }
        }
        return summ;
    }
}
