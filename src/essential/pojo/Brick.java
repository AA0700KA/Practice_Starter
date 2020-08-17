package essential.pojo;

import essential.BattleField;
import essential.interfaces.Destroyable;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * Created by Asus on 21.09.2019.
 */
public class Brick extends BFObject implements Destroyable {

    private ImageIcon destroyableIcon;

    public Brick() {
        setIcon(new ImageIcon(getClass().getResource("/images/brick.png")));
        destroyableIcon = new ImageIcon(getClass().getResource("/images/blank.png"));
    }

    private boolean destroyed;

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    @Override
    public void destroy() {
        destroyed = true;
    }

    @Override
    public void draw(Graphics g) {
//        Color color = !destroyed ? new Color(155, 0, 0) : new Color(180, 180, 180);
//        g.setColor(color);
//        g.fillRect(getX(), getY(), 64, 64);

        ImageIcon icon = !destroyed ? getIcon() : destroyableIcon;

        g.drawImage(icon.getImage(), getX(), getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });

    }

}
