package essential.collections.impl;

import essential.collections.interfaces.GameCollection;
import essential.objects.Coordinate;
import essential.objects.enums.Direction;
import essential.objects.abstracts.BFObject;
import essential.objects.abstracts.MovableObject;
import essential.objects.enums.GameAction;
import essential.objects.impl.Brick;
import essential.objects.impl.Ground;
import essential.objects.impl.Tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 19.08.2020.
 */
public class ArrayCollection implements GameCollection {

    private BFObject[][] battleField = {
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
            {new Brick(), new Tank(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Tank(), new Ground(), new Brick()},
            {new Ground(),new Ground(),new Tank(),new Ground(), new Ground(), new Ground(), new Ground(), new Ground(),new Ground()},
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Tank(), new Brick()},
    };

    private List<MovableObject> movableObjects = new ArrayList<>();

    public ArrayCollection() {
        initCollection();
    }

    private void initCollection() {
        for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField[i].length; j++) {
                BFObject object = battleField[i][j];
                Coordinate coordinate = new Coordinate(i, j);
                object.setCoordinate(coordinate);

                if (object instanceof MovableObject) {
                    MovableObject movableObject = (MovableObject) object;
                    movableObjects.add(movableObject);
                }
            }
        }

        System.out.println("Count of movable objects: " + movableObjects.size());

    }

    @Override
    public void moveAll() {
        for (MovableObject movableObject : movableObjects) {
            move(movableObject, Direction.UP);
        }
    }

    @Override
    public void move(MovableObject movableObject, Direction direction) {
         movableObject.setDirection(direction);
         Coordinate coordinate = movableObject.getCoordinateByDirection(direction);
         BFObject nextObject = getObjectByCoordinate(coordinate);
        GameAction action = movableObject.getActionToObject(nextObject);

        switch (action) {
            case MOVE:
                 swapObjects(movableObject, nextObject);
                break;
            case FIRE:
        }
    }

    private void swapObjects(BFObject current, BFObject next) {
        BFObject tmp = current;
        int currentX = current.getCoordinate().getX();
        int currentY = current.getCoordinate().getY();

        int nextX = next.getCoordinate().getX();
        int nextY = next.getCoordinate().getY();

        battleField[currentY][currentX] = battleField[nextY][nextX];
        battleField[nextY][nextX] = tmp;

        battleField[currentY][currentX].setCoordinate(new Coordinate(currentY, currentX));
        battleField[nextY][nextX].setCoordinate(new Coordinate(nextY, nextX));
    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField[i].length; j++) {
                battleField[i][j].draw(g);
            }
        }
    }

    @Override
    public BFObject getObjectByCoordinate(Coordinate coordinate) {
        int y = coordinate.getY();
        int x = coordinate.getX();

        try {
            return battleField[y][x];
        } catch (RuntimeException e) {
            return null;
        }

    }
}
