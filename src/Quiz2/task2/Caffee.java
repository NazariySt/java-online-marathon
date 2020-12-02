package Quiz2.task2;

import java.util.HashMap;
import java.util.Map;

public class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private String name;
    private int rating;
    private Map<String , Integer> ingredients;

    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.ingredients = new HashMap<>();
    }

    @Override
    public Map<String, Integer> makeDrink() {
        addComponent("Water", 100);
        addComponent("Arabica", 20);
        return ingredients;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        ingredients.put(componentName , componentCount);
        return this;
    }

    @Override
    public int getRating() {
        return rating;
    }
}
