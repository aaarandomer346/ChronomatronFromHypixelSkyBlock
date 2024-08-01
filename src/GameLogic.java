import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameLogic implements ActionListener {
    int nextKeyNum = 1;
    int[] keyString = new int[100];
    Random random = new Random();

    void startGame() {
        setUpButtons();
        keyString[0] = random.nextInt(10) - 1;
        playNotes();
    }

    void nextKey() {
        if (nextKeyNum != 100) {
            keyString[nextKeyNum] = random.nextInt(10) - 1;
            nextKeyNum++;
            playNotes();
        }

    }

    void playNotes() {
        for (int i : keyString) {
            System.out.println(i);

            sleepTask();
            GameFrame.buttons[i].setBackground(Color.blue);
            sleepTask();
            GameFrame.buttons[i].setBackground(Color.BLACK);
        }
        sleepTask();
    }

    void sleepTask() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {throw new RuntimeException(e);}
    }

    void setUpButtons() {
        for(JButton button : GameFrame.buttons){
            button.addActionListener(this);
            button.setFocusable(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == GameFrame.buttons[keyString[nextKeyNum]]) {
            nextKey();
        }
    }
}
