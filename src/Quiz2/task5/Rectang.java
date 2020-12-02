package Quiz2.task5;

public class Rectang {
    private double x;
    private double y;

    public Rectang(double x, double y){
        this.x = x;
        this.y = y;
    }


    public double getPerimeter(){
        return 2 * (x + y);
    }
}
