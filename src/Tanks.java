
import jdk.nashorn.internal.runtime.ECMAException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Tanks extends JPanel {


    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    // 1 - top, 2 - bottom, 3 - left, 4 - right
    int tankDirection = 1;

    int tankX = 448;
    int tankY = 512;

    int bulletX = -100;
    int bulletY = -100;

    int speed = 10;
    int bulletSpeed = 3;

    String[][] battleField = {
            {"B", " ", "B", "B", "B", "B", "B", " ", "B"},
            {" ", " ", " ", "B", " ", " ", " ", "B", "B"},
            {" ", "B", "B", "B", "B", "B", "B", " ", "B"},
            {" ", " ", "B", "B", " ", "B", "B", " ", "B"},
            {" ", "B", " ", "B", "B", " ", "B", " ", "B"},
            {" ", " ", "B", "B", "B", "B", "B", " ", "B"},
            {" ", "B", " ", " ", " ", " ", "B", " ", "B"},
            {" ", " ", " ", "B", "B", " ", "B", " ", "B"},
            {" ", "B", " ", " ", " ", " ", "B", " ", "B"}
    };

    /**
     * Write your code here.
     */
    void runTheGame() throws Exception {

        move(1);
        move(3);
        move(3);
        fire();

        moveToQuadrant(0,2);


      //  moveRandom();



    }

    public void moveToQuadrant(int y, int x) {
        int realY = y*64;
        int realX = x*64;

    }

    public void moveRandom()  {

    }

    boolean processInterception() {
//        String cordinates = getQuadrant(bulletX, bulletY);
//        String x1 = cordinates.substring(cordinates.indexOf("_") + 1);
//        String y1 = cordinates.substring(0, cordinates.indexOf("_"));
        int x = bulletX/64;
        int y = bulletY/64;
        if (x < 9 && x >= 0 && y >= 0 && y < 9) {
            if (battleField[y][x] == "B") {
                battleField[y][x] = " ";
                return true;
            }
        }
        return false;
    }

    String getQuadrant(int x, int y) {
        int vert = y/64, gor = x/64;
        return vert + "_" + gor;
    }

    void fire() throws Exception {
        bulletY = tankY + 25;
        bulletX = tankX + 25;

        while (bulletX < 576 && bulletX > 0 && bulletY > 0 && bulletY < 576) {
            if (tankDirection == 1)
            {
                bulletY -= 1;
            }
            else if (tankDirection == 2)
            {
                bulletY += 1;
            }
            else if (tankDirection == 3)
            {
                bulletX -= 1;
            }

            else {
                bulletX += 1;
            }

            if (processInterception()) {
                bulletY = -100;
                bulletX = -100;

            }


            repaint();
            Thread.sleep(bulletSpeed);
        }

        bulletX = -100;
        bulletY = -100;
        repaint();

    }


    String getQuadrantXY(int v, int h) {
        int vertical = (v-1)*64;
        int gorisontal = (h-1)*64;

        return vertical + "_" + gorisontal;
    }

    void move(int direction) throws Exception {
        int covered = 0;

        if ((direction == 1 && tankY == 0)||(direction == 2 && tankY >= 512) ||(direction == 3 && tankX == 0)||(direction == 4 && tankX >= 512)) {
            System.out.println("Can't move:" + direction + "tankX:" + tankX + "tankY:" + tankY);
            return;
        }

        turn(direction);


        while (covered < 64) {
            if (direction == 1) {
                tankY -= 1;
                System.out.println(direction + "tankX:" + tankX + "tankY:" + tankY);
            }

            else if (direction == 2) {
                tankY += 1;
                System.out.println(direction + "tankX:" + tankX + "tankY:" + tankY);
            }

            else if (direction == 3) {
                tankX -= 1;
                System.out.println(direction + "tankX:" + tankX + "tankY:" + tankY);
            }

            else {
                tankX += 1;
                System.out.println(direction + "tankX:" + tankX + "tankY:" + tankY);
            }
            covered++;
            repaint();
            Thread.sleep(speed);
        }

    }

    void turn(int direction) {
        if (tankDirection != direction) {
            tankDirection = direction;
        }
    }





    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.


    public static void main(String[] args) throws Exception {
        Tanks bf = new Tanks();
        bf.runTheGame();
    }

    public Tanks() {
        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                cc = new Color(180, 180, 180);
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }

        for (int j = 0; j < battleField.length; j++) {
            for (int k = 0; k < battleField.length; k++) {
                if (battleField[j][k].equals("B")) {
//                    String coordinates = getQuadrantXY(j + 1, k + 1);
//                    int separator = coordinates.indexOf("_");
                    int y = j*64;
                    int x = k*64;
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x, y, 64, 64);
                }
            }
        }

        g.setColor(new Color(255, 10, 14));
        g.fillRect(tankX, tankY, 64, 64);

        g.setColor(new Color(0, 255, 0));

        if (tankDirection == 1) {
            g.fillRect(tankX + 20, tankY, 24, 34);
        } else if (tankDirection == 2) {
            g.fillRect(tankX + 20, tankY + 30, 24, 34);
        } else if (tankDirection == 3) {
            g.fillRect(tankX, tankY + 20, 34, 24);
        } else {
            g.fillRect(tankX + 30, tankY + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bulletX, bulletY, 14, 14);
    }

}
