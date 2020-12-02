package Quiz2.task6;

import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {
        double maxCircle = 0;
        double maxRectangle = 0;

        for(Shape shape : shapes){
            if(shape instanceof Circle){
                if(shape.getArea() > maxCircle){
                    maxCircle = shape.getArea();
                }
            }
            else{
                if(shape.getArea() > maxRectangle){
                    maxRectangle = shape.getArea();
                }
            }
        }

        List<Shape> ourList = new ArrayList<>();
        for(Shape shape : shapes){
            if(!ourList.contains(shape)) {
                if (shape instanceof Circle) {
                    if (shape.getArea() == maxCircle) {
                        ourList.add(shape);
                    }
                } else {
                    if (shape.getArea() == maxRectangle) {
                        ourList.add(shape);
                    }
                }
            }
        }

        return ourList;
    }

    public static void main(String[] args){
        List<Shape> originList = new ArrayList<>();

        originList.add(new Circle("Circle", 2.0));
        originList.add(new Rectangle("Rectangle", 2.0, 3.0));
        originList.add(new Circle("Circle", 1.0));
        originList.add(new Rectangle("Rectangle", 3.0, 2.0));
        originList.add(new Circle("Circle",0.5));
        originList.add(new Rectangle("Rectangle", 1.0, 2.0));

        List<Shape> actual = new MyUtils().maxAreas(originList);
        for(Shape shape : actual) {
            if(shape instanceof Circle){
                System.out.println(shape.getName() + " " + ((Circle) shape).getRadius());
            }
            else{
                System.out.println(shape.getName() + " " + ((Rectangle) shape).getHeight() + " " + ((Rectangle) shape).getWidth());
            }
        }
    }
}
