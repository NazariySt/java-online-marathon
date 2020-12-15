package Quiz6.task3;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class App {
    static BinaryOperator<String> greetingOperator = (String first, String second) -> {
        return "Hello" + first + " " + second + "!!!";
    };

    public static List<String> creatGreetings(List<Person> listPersons, BinaryOperator<String> binaryOperator) {
        List<String> ourList = new ArrayList<>();
        for (Person person : listPersons) {
            ourList.add(binaryOperator.apply(person.name, person.surname));
        }
        return ourList;
    }
}
