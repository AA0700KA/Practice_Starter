package essential.pojo;

import essential.interfaces.Destroyable;
import essential.interfaces.Drawable;

import java.awt.*;

/**
 * Created by Asus on 21.09.2019.
 */
public class Bullet implements Drawable, Destroyable {

    private int x = -100;
    private int y = -100;
    private final int speed = 3;

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(255, 255, 0));
        g.fillRect(x, y, 14, 14);
    }

    @Override
    public boolean isDestroyed() {
        return !(x < 576 && x > 0 && y > 0 && y < 576);
    }

    @Override
    public void destroy() {
        x = -100;
        y = -100;
    }

}
