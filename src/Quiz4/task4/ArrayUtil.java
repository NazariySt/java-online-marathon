package Quiz4.task4;

public class ArrayUtil {
    public static <T> T setAndRuturn(T[] array, T value, int pos) {

        array[pos] = value;


        return array[pos];
    }

    public static void main(String[] args) {
        Integer [] numbers = new Integer[3];
        int numberFromPos = ArrayUtil.<Integer>setAndRuturn(numbers , 45 , 1);
        System.out.println(numberFromPos);
    }


}
