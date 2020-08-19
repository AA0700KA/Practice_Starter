package essential.objects.impl;

import essential.objects.abstracts.BFObject;
import essential.objects.enums.ObjectType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * Created by Asus on 21.09.2019.
 */
public class Ground extends BFObject {

    public Ground() {
        setIcon(new ImageIcon(getClass().getResource("/images/blank.png")));
        setType(ObjectType.GROUND);
    }


}
