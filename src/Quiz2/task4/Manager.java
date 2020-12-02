package Quiz2.task4;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.*;

public class Manager extends Employee {
    private double coefficient;

    public String getName() {
        return super.getName();
    }

    public int getExperience() {
        return super.getExperience();
    }

    public BigDecimal getPayment() {
        return new BigDecimal(coefficient).multiply(super.getPayment());
    }

    public double getCoefficient() {
        return coefficient;
    }

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return getExperience() == manager.getExperience() &&
                Objects.equals(getName(), manager.getName()) &&
                Objects.equals(getPayment(), manager.getPayment()) &&
                Double.compare(manager.coefficient, coefficient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficient);
    }
}
