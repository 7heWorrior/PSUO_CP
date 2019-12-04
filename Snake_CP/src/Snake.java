import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    List<Point> snakePoints;
    int xDir,yDir;
    boolean isMoving,elongate;
    final int STARTSIZE = 20, startX = 150, startY = 150;

    public Snake(){
        snakePoints = new ArrayList<Point>();
                xDir = 0;
                yDir = 0;
                isMoving = false;
                elongate = false;
                snakePoints.add(new Point(startX,startY));
                for(int i=1;i<STARTSIZE;i++)
                {
                    snakePoints.add(new Point(startX - i*4,startY));
                }
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        for(Point p : snakePoints){
            int x = (int) p.getX();
            int y = (int) p.getY();
            g.fillRect(x,y,4,4);

        }
    }
    public void move(){
        if (isMoving) {
            Point temp = snakePoints.get(0);
            Point last = snakePoints.get(snakePoints.size() - 1);
            Point newStart = new Point(temp.getX() + xDir*4,temp.getY() + yDir*4);
            for (int i = snakePoints.size() -1 ; i >=0; i--){
                snakePoints.set(i,snakePoints.get(i-1));
            }
            snakePoints.set(0,newStart);
        }
    }
    public boolean isMoving()
    {
        return isMoving;
    }
    public void setisMoving(boolean b)
    {
        this.isMoving = b;
    }
    public int getxDir() {
        return xDir;
    }
    public int getyDir(){
        return yDir;
    }

    public void setxDir(int xDir) {
        this.xDir = xDir;
    }

    public void setyDir(int yDir) {
        this.yDir = yDir;
    }
    //x position of the snake's head
    public double getX(){
        return snakePoints.get(0).getX();
    }
    public double getY(){
        return  snakePoints.get(0).getY();
    }
}
