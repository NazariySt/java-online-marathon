package Quiz2.task6;

import java.util.Objects;

public class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius){
        super(name);
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double getRadius(){
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRadius());
    }
}
