package Quiz2.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public double getArea(){
        return height * width;
    }

    public Rectangle(String name, double height, double width){
        super(name);
        this.height = height;
        this.width = width;
    }

    public double getHeight(){
        return height;
    }

    public double getWidth(){
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.getHeight(), getHeight()) == 0 &&
                Double.compare(rectangle.getWidth(), getWidth()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getHeight(), getWidth());
    }
}

