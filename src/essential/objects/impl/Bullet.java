package essential.objects.impl;

import essential.objects.abstracts.MovableObject;
import essential.objects.enums.ObjectType;

import java.awt.*;

/**
 * Created by Asus on 21.09.2019.
 */
public class Bullet extends MovableObject  {

    private final int speed = 3;


    public Bullet() {
        setType(ObjectType.BULLET);
    }


    public int getSpeed() {
        return speed;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(255, 255, 0));
        g.fillRect(getCoordinate().getX()*64, getCoordinate().getY()*64, 14, 14);
    }



}
