package essential.objects.abstracts;

import essential.objects.Coordinate;
import essential.objects.enums.Direction;
import essential.objects.enums.GameAction;
import essential.objects.impl.Brick;

import javax.swing.*;

/**
 * Created by Asus on 19.08.2020.
 */
public abstract class MovableObject extends BFObject {

    private Direction direction = Direction.UP;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Coordinate getCoordinateByDirection(Direction direction) {

        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();

        switch (direction) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
        }

        Coordinate coordinate = new Coordinate(y, x);
        return coordinate;
    }

    public GameAction getActionToObject(BFObject object) {

        if (object == null) {
            return GameAction.NONE;
        }

        switch (object.getType()) {
            case GROUND:
                return GameAction.MOVE;
            case BRICK:
            case TANK:
                return GameAction.FIRE;

        }

        return GameAction.NONE;
    }

}
