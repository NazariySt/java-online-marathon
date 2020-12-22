package Quiz8.task1;

import java.util.function.BinaryOperator;

public class ParallelCalculator implements Runnable {
    public int result = 0;

    public ParallelCalculator(BinaryOperator<Integer> binaryOperator, int operand1, int operand2) {
        result = binaryOperator.apply(operand1, operand2);

    }

    @Override
    public void run() {

    }
}
