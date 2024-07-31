import javax.swing.*;
import java.awt.*;

public class GameFrame {

    static JButton[] buttons = new JButton[11];

    void MakeFrame() {
        buttons[1] = new JButton();
        buttons[2] = new JButton();
        buttons[3] = new JButton();
        buttons[4] = new JButton();
        buttons[5] = new JButton();
        buttons[6] = new JButton();
        buttons[7] = new JButton();
        buttons[8] = new JButton();
        buttons[9] = new JButton();
        buttons[10] = new JButton();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(2,5,10,10));

        for (JButton button : buttons) {
            if(button != null) {
                button.setBackground(Color.black);
            }
        }

        for(int i = 1; i < 11; i++) {
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
    }
}
