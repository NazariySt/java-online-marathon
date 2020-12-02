package Quiz2.task2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {
    private Map<String , Double> avarageRating(List<Caffee> coffees){
        double espressoTot = 0;
        double capuchinoTot = 0;
        double coffeeTot = 0;

        int espressoNum = 0;
        int cappuchinoNum = 0;
        int coffeeNum = 0;

        for (Caffee c : coffees){
            if(c instanceof Cappuccino){
                capuchinoTot += c.getRating();
                cappuchinoNum++;
            }
            else if(c instanceof Espresso){
                espressoTot += c.getRating();
                espressoNum++;
            }
            else if(c != null){
                coffeeTot += c.getRating();
                coffeeNum++;
            }
    }
        Map<String, Double> results = new HashMap<>();
        if(espressoNum > 0) {
            results.put("Espresso", (espressoTot / espressoNum));
        }
        if(cappuchinoNum > 0) {
            results.put("Cappuccino", (capuchinoTot / cappuchinoNum));
        }
        if(coffeeNum > 0){
            results.put("Caffee", (coffeeTot / coffeeNum));
        }

        return results;
    }
}
