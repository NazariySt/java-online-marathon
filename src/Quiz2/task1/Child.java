package Quiz2.task1;

public class Child extends Person {
    String childIDNumber;

    public Child(int age, String name, String healthInfo, String childIDNumber) {
        super(age, name, healthInfo);
        this.childIDNumber = childIDNumber;
    }

    @Override
    String getHealthStatus() {
        return name + " " + healthInfo;
    }
}
