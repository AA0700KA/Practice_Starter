package essential;

import essential.pojo.*;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BattleField extends JPanel {


    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;


   Tank tank;
   Tank tank2;



    BFObject[][] battleField = {
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
            {new Ground(),new Ground(),new Ground(),new Ground(), new Ground(), new Ground(), new Ground(), new Ground(),new Ground()},
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
            {new Brick(), new Ground(), new Brick(), new Brick(), new Brick(), new Brick(), new Brick(), new Ground(), new Brick()},
    };

    /**
     * Write your code here.
     */
    void runTheGame() throws Exception {


//        tank2.kill(tank);


       Thread thread1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    tank.kill(tank2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        Thread thread2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    tank2.kill(tank);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();


    }

    public boolean processInterception() {
//        String cordinates = getQuadrant(bulletX, bulletY);
//        String x1 = cordinates.substring(cordinates.indexOf("_") + 1);
//        String y1 = cordinates.substring(0, cordinates.indexOf("_"));

           int x = tank.getBullet().getX() / 64;
           int y = tank.getBullet().getY() / 64;

           int xTank1 = tank.getX()/64;
           int yTank1 = tank.getY()/64;

           int xTank2 = tank2.getX()/64;
           int yTank2 = tank2.getY()/64;

           if (x == xTank1 && y == yTank1) {
               tank.destroy();
               return true;
           }

           if (x == xTank2 && y == yTank2) {
               tank2.destroy();
               return true;
           }



           if (x < 9 && x >= 0 && y >= 0 && y < 9) {
               if (battleField[y][x].getClass() == Brick.class
                       && !((Brick) battleField[y][x]).isDestroyed()) {
                   Brick brick = (Brick) battleField[y][x];
                   brick.destroy();
                   return true;
               }


           }

        return false;
    }

    String getQuadrant(int x, int y) {
        int vert = y/64, gor = x/64;
        return vert + "_" + gor;
    }


    String getQuadrantXY(int v, int h) {
        int vertical = (v-1)*64;
        int gorisontal = (h-1)*64;

        return vertical + "_" + gorisontal;
    }







    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.


    public static void main(String[] args) throws Exception {
        BattleField bf = new BattleField();
        bf.runTheGame();
    }

    public BattleField() throws Exception {
        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
        tank = new Tank(this);
        tank2 = new Tank(this);
        tank2.setX(384);
        tank2.setY(320);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        for (int j = 0; j < battleField.length; j++) {
            for (int k = 0; k < battleField.length; k++) {

                    BFObject object = battleField[j][k];
                    int y = j*64;
                    int x = k*64;
                    object.setY(y);
                    object.setX(x);
                    object.draw(g);
            }
        }



        tank.draw(g);
        tank2.draw(g);

    }

}
