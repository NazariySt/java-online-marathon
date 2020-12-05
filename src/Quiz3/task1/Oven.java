package Quiz3.task1;

public class Oven {
    public static Pizza cook(){
        return Pizza.base().addCheese("cheese").addMeat("meat").addMushroom("").build();
    }
}
