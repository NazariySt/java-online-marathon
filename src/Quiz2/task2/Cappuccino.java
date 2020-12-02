package Quiz2.task2;

import java.util.HashMap;
import java.util.Map;

public class Cappuccino extends Caffee {
    private Map<String, Integer> ingredients;
    public Cappuccino(String name, int rating) {
        super(name, rating);
        this.ingredients = new HashMap<>();
    }

    @Override
    public Map<String, Integer> makeDrink(){
        addComponent("Water", 100);
        addComponent("Arabica", 20);
        addComponent("Milk", 50);

        return ingredients;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        ingredients.put(componentName, componentCount);
        return this;
    }
}
