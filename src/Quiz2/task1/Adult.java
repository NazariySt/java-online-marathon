package Quiz2.task1;

public class Adult extends Person {
    String passportNumber;

    public Adult(int age, String name, String healthInfo, String passportNumber) {
        super(age, name, healthInfo);
        this.passportNumber = passportNumber;
    }

    String getHealthStatus() {
        return name + " " + healthInfo;
    }
}
