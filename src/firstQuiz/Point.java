package firstQuiz;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getXYPair() {
        int[] a = new int[2];
        a[0] = x;
        a[1] = y;
        return a;
    }
    public double distance(int x , int y) {
        double a1 = this.x - x;
        double a2 = this.y - y;
        return Math.sqrt(a1*a1 + a2*a2);
    }
    public double distance (Point point) {
        double dx = this.x - point.x;
        double dy = this.y - point.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
    public double distance (){
        Point p = new Point(0,0);
        double a = this.x - p.x;
        double b = this.y - p.y;
        double dis = Math.sqrt(a*a + b*b);
        return dis;
    }
}
