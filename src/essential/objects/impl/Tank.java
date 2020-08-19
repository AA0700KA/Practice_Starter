package essential.objects.impl;

import essential.objects.enums.Direction;
import essential.objects.abstracts.MovableObject;
import essential.objects.enums.ObjectType;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Asus on 21.09.2019.
 */
public class Tank extends MovableObject  {

  private final int speed = 10;
  private ImageIcon[] images = new ImageIcon[4];

    public Tank() {
       setType(ObjectType.TANK);
    }


    public int getSpeed() {
        return speed;
    }




    @Override
    public void draw(Graphics g) {

        //g.drawImage()

            g.setColor(new Color(255, 0, 0));
            g.fillRect(getCoordinate().getX()*64, getCoordinate().getY()*64, 64, 64);

            g.setColor(new Color(0, 255, 0));
            if (getDirection() == Direction.UP) {
                g.fillRect(getCoordinate().getX()*64 + 20, getCoordinate().getY()*64, 24, 34);
            } else if (getDirection() == Direction.DOWN) {
                g.fillRect(getCoordinate().getX()*64 + 20, getCoordinate().getY()*64 + 30, 24, 34);
            } else if (getDirection() == Direction.LEFT) {
                g.fillRect(getCoordinate().getX()*64, getCoordinate().getY()*64 + 20, 34, 24);
            } else {
                g.fillRect(getCoordinate().getX()*64 + 30, getCoordinate().getY()*64 + 20, 34, 24);
            }


    }

}
