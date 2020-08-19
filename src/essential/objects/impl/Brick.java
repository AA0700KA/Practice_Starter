package essential.objects.impl;

import essential.objects.abstracts.BFObject;
import essential.objects.enums.ObjectType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * Created by Asus on 21.09.2019.
 */
public class Brick extends BFObject  {

    public Brick() {
        setIcon(new ImageIcon(getClass().getResource("/images/brick.png")));
        setType(ObjectType.BRICK);
    }


}
