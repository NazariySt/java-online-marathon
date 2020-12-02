package Quiz2.task4;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment){
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName(){
        return name;
    }

    public int getExperience(){
        return experience;
    }

    public BigDecimal getPayment(){
        return basePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getExperience() == employee.getExperience() &&
                Objects.equals(getName(), employee.getName()) &&
                Objects.equals(basePayment, employee.basePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getExperience(), basePayment);
    }
}
