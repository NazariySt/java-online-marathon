package Quiz2.task1;

public class Person {
    int age;
    String name;
    String healthInfo;

    public Person(int age, String name, String healthInfo) {
        this.age = age;
        this.name = name;
        this.healthInfo = healthInfo;
    }
    String getHealthStatus(){
        return healthInfo;
    }
}
