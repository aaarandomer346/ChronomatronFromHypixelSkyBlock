import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameLogic implements ActionListener {
    int keyNum = 0;
    int nextKeyNum = 1;
    int[] keyString = new int[100];
    Random random = new Random();

    void startGame() {
        setActionListener();
        keyString[0] = random.nextInt(10) + 1;
        playNotes();
    }

    void nextKey() {
        if (nextKeyNum != 100) {
            keyString[nextKeyNum] = random.nextInt(10);
            nextKeyNum++;
            playNotes();
        }

    }

    void playNotes() {
        for (int i : keyString) {
            System.out.println(i);
            if(i == 0){
                break;
            }
            sleepTask();
            GameFrame.buttons[i].setBackground(Color.blue);
            System.out.println("blue");
            sleepTask();
            GameFrame.buttons[i].setBackground(Color.BLACK);
            System.out.println("black");
        }
        sleepTask();
    }

    void sleepTask() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {throw new RuntimeException(e);}
    }

    void setActionListener() {
        for(int i = 1; i < 11; i++) {
            GameFrame.buttons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() != GameFrame.buttons[keyString[keyNum]]) {
            System.exit(0);
        } else {
            if(keyString[keyNum + 1] == 0) {
                keyNum = 0;
                nextKey();
            } else {
                keyNum++;
            }
        }
    }
}
