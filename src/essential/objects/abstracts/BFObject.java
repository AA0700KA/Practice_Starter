package essential.objects.abstracts;

import essential.objects.Coordinate;
import essential.objects.enums.ObjectType;
import essential.objects.interfaces.Drawable;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;


public abstract class BFObject implements Drawable {

    private Coordinate coordinate;
    private ImageIcon icon;
    private ObjectType type;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public ObjectType getType() {
        return type;
    }

    public void setType(ObjectType type) {
        this.type = type;
    }

    @Override
    public void draw(Graphics g) {
        ;
        g.drawImage(getIcon().getImage(), getCoordinate().getX()*64, getCoordinate().getY()*64, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });

    }

}
