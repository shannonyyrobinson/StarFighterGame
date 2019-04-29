//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing {

    private int speed;
    private Image image;
    private boolean isDead = false;

    public Ship() {
        this(10, 10, 10, 10, 10);
    }

    public Ship(int x, int y) {
        //add code here
        this(x,y,10,10,10);
    }

    public Ship(int x, int y, int s) {
        //add code here
        this(x,y,10,10,s);
    }

    public Ship(int x, int y, int w, int h, int s) {
        super(x, y, w, h);
        speed = s;
        try {
            URL url = getClass().getResource("ship.jpg");
            image = ImageIO.read(url);
        } catch (Exception e) {
            //feel free to do something here
        }
    }

    public void setSpeed(int s) {
        speed = s;
    }

    public int getSpeed() {
        return speed;
    }
    
    public void setDead(boolean b){
        isDead = b;
    }
    public boolean getDead(){
        return isDead;
    }

    public void move(String direction) {
        if(direction.equals("LEFT")&&getX()>0){
            setX(getX()-speed);
        }
        if(direction.equals("RIGHT")&&getX()<750){
            setX(getX()+speed);
        }
        if(direction.equals("UP")&&getY()>0){
            setY(getY()-speed);
        }
        if(direction.equals("DOWN")&&getY()<500){
            setY(getY()+speed);
        }
    }

    public void draw(Graphics window) {
        if(!isDead){
            window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
        }
    }

    public String toString() {
        return super.toString() + getSpeed();
    }
}