public class Point {
    private double x,y;
    public Point()
    {
        x=0;
        y=0;
    }
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public void setX(double x)
    {
        this.x = x;
    }
    public void setY(double y)
    {
        this.y = y;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
}
