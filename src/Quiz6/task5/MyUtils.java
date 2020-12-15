package Quiz6.task5;

import java.util.Set;
import java.util.function.Predicate;

public class MyUtils {
    static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicates) {
        Predicate<Integer> integerPredicate = null;

        for (Predicate<Integer> predicate : predicates) {
            integerPredicate = predicate;
            break;
        }

        for (Predicate<Integer> predicate : predicates) {
            integerPredicate = integerPredicate.and(predicate);
        }
        return integerPredicate;
    }
}
