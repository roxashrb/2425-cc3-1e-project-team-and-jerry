import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame userFrame = new JFrame("Hotel Something");
        userFrame.setSize(800, 600);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setLayout(null);
        userFrame.setVisible(true);

        JTextField textDisplay = new JTextField();
        textDisplay.setBounds(50, 50, 50, 50);
        textDisplay.setEditable(false);
        textDisplay.setFocusable(false);
        userFrame.add(textDisplay);

        JButton startButton = new JButton("Start");
        startButton.setBounds(500, 300, 100, 50);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textDisplay.setText("Start");
            }
        });

        userFrame.add(startButton);
    }
}
