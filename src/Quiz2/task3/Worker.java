package Quiz2.task3;

import java.util.Objects;

public class Worker extends Person {
    private String workPosition;
    private int expirienceYears;

    public Worker(String name, String workPosition, int expirienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.expirienceYears = expirienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExpirienceYears() {
        return expirienceYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return getExpirienceYears() == worker.getExpirienceYears() &&
                Objects.equals(getWorkPosition(), worker.getWorkPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWorkPosition(), getExpirienceYears());
    }
}
