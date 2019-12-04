import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame extends Applet implements Runnable, KeyListener {
    Graphics gfx;
    Image img;
    Thread thread;
    Snake snake;
    public void init()
    {
        this.resize(400,400 );
        img = createImage(400,400);
        gfx = img.getGraphics();
        snake = new Snake();
        thread = new Thread(this);
        thread.start();
    }
    public void paint(Graphics g)
    {
        gfx.setColor(Color.BLACK);
        gfx.fillRect(0,0,400,400);
        snake.draw(gfx);

        g.drawImage(img,0,0,null);
    }
    public void update(Graphics g)
    {
        paint(g);
    }
    public void  repaint(Graphics g)
    {
        paint(g);
    }

    public void run() {
        for (;;){

            snake.move();
            this.repaint();

            try {
                thread.sleep(40);
            } catch (InterruptedException e ){
                e.printStackTrace();
            }
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (!snake.isMoving){
            if(e.getKeyCode() == KeyEvent.VK_UP ||e.getKeyCode() == KeyEvent.VK_DOWN ||e.getKeyCode() == KeyEvent.VK_LEFT ||e.getKeyCode() == KeyEvent.VK_RIGHT ){
                snake.setisMoving(true);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("UP");
            if (snake.getyDir() != 1) {
                snake.setyDir(-1);
                snake.setxDir(0);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (snake.getyDir() != -1) {
                snake.setxDir(0);
                snake.setyDir(1);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (snake.getxDir() != 1) {
                snake.setxDir(-1);
                snake.setyDir(0);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (snake.getxDir() != -1) {
                snake.setyDir(0);
                snake.setxDir(1);
            }
        }
    }
    public void keyReleased(KeyEvent e) {

    }
}
