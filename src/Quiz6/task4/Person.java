package Quiz6.task4;

public class Person implements DecisionMethod {
    String name;

    public Person(String name) {
        this.name = name;
    }

  public DecisionMethod goShopping = (a, b) -> a.equals("product1") && b > 10;

    @Override
    public boolean decide(String product, int discount) {
        return product.equals("product1") && discount > 10;
    }
}