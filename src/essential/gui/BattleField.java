package essential.gui;

import essential.collections.impl.ArrayCollection;
import essential.collections.interfaces.GameCollection;

import javax.swing.*;
import java.awt.*;

public class BattleField extends JPanel {


    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;


   private GameCollection collection = new ArrayCollection();

   
    void runTheGame() throws Exception {
        while (true) {
            collection.moveAll();
        }
    }



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
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        collection.draw(g);
    }

}
