package essential.collections.interfaces;

import essential.objects.Coordinate;
import essential.objects.enums.Direction;
import essential.objects.abstracts.BFObject;
import essential.objects.abstracts.MovableObject;

import java.awt.*;

/**
 * Created by Asus on 19.08.2020.
 */
public interface GameCollection {

    void draw(Graphics g);

    void move(MovableObject movableObject, Direction direction);

    void moveAll();

    BFObject getObjectByCoordinate(Coordinate coordinate);

}
