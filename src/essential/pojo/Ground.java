package essential.pojo;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * Created by Asus on 21.09.2019.
 */
public class Ground extends BFObject {

    public Ground() {
        setIcon(new ImageIcon(getClass().getResource("/images/blank.png")));
    }

    @Override
    public void draw(Graphics g) {
        ;
        g.drawImage(getIcon().getImage(), getX(), getY(), new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });
//        Color cc = new Color(180, 180, 180);
//        g.setColor(cc);
//        g.fillRect(getX(), getY(), 64, 64);
    }

}
