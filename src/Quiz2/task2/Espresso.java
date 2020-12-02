package Quiz2.task2;

import java.util.HashMap;
import java.util.Map;

public class Espresso extends Caffee {
    private Map<String, Integer> ingredients;
    public Espresso(String name, int rating) {
        super(name, rating);
        this.ingredients = new HashMap<>();
    }

    @Override
    public Map<String, Integer> makeDrink(){
        addComponent("Water", 50);
        addComponent("Arabica", 20);

        return ingredients;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        ingredients.put(componentName, componentCount);
        return this;
    }
}
