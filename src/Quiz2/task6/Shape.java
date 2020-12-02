package Quiz2.task6;

import java.util.Objects;

public abstract class Shape {
    private String name;

    public Shape(String name){
        this.name = name;
    }

    public abstract double getArea();

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;
        Shape shape = (Shape) o;
        return Objects.equals(getName(), shape.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
