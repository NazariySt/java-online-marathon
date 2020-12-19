package Quiz7.task6;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {
    public Map<String, List<String>> phoneNumbers(List<Stream<String>> list) {
        return list.stream()
                .flatMap(Function.identity())
                .sorted()
                .map(str -> str.replaceAll("[- ()]", ""))
                .map(str -> {
                    if (str.length() == 7) {
                        return "loc" + str;
                    } else if (str.length() == 10) {
                        return str;
                    } else {
                        return "err" + str;
                    }
                })
                .collect(Collectors.groupingBy(str -> str.substring(0, 3), Collectors.mapping(str -> str.substring(3), Collectors.toList())));
    }
}
