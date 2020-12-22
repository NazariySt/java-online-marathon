package Quiz8.task2;

import Quiz8.task1.ParallelCalculator;

public class Accountant {
    static int summ(int x, int y) {
        ParallelCalculator parallelCalculator = new ParallelCalculator(Integer::sum, x, y);
        Thread thread = new Thread(parallelCalculator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException interException) {
            interException.printStackTrace();
        }
        return parallelCalculator.result;
    }
}
