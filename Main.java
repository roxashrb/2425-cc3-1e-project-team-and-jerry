import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    static JButton roomI, roomII, roomIII, roomIV, roomV, roomVI;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Room Reservations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 600);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 3));
        
        JButton[] rooms = new JButton[6];
        String[] roomStatus = {"Vacant", "Vacant", "Vacant", "Vacant", "Vacant", "Vacant"};
        
        for (int i = 0; i < 6; i++) {
            int roomNumber = i;
            rooms[i] = new JButton("Room " + (i + 1) + ": " + roomStatus[i]);
            rooms[i].setBackground(Color.white);
            rooms[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedRoom = (JButton) e.getSource();
                    if (roomStatus[roomNumber].equals("Vacant")) {
                        roomStatus[roomNumber] = "Reserved";
                        clickedRoom.setText("Room " + (roomNumber + 1) + ": " + roomStatus[roomNumber]);
                    } else {
                        roomStatus[roomNumber] = "Vacant";
                        clickedRoom.setText("Room " + (roomNumber + 1) + ": " + roomStatus[roomNumber]);
                    }
                }
            });
            
            panel.add(rooms[i]);
        }
        
        frame.add(panel);
    }
}
