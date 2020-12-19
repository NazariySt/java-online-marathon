package Quiz7.task5;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyUtil {
    public Stream< String> nameList (Map<String, Stream<String>> map) throws NullPointerException{
        if (map != null) {
            return map.values()
                    .stream()
                    .flatMap(Function.identity())
                    .filter(Objects::nonNull)
                    .map(str -> str.replace(" ",""))
                    .filter(str -> !str.isEmpty())
                    .map(String::toLowerCase)
                    .distinct()
                    .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
                    .sorted();
        } else throw new NullPointerException();
    }
}
