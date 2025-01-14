import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //interface
        JFrame userFrame = new JFrame("Hotel Something");
        userFrame.setSize(1200, 700);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setLayout(null);
        userFrame.setVisible(true);

        JButton startButton = new JButton("Start");
        startButton.setBounds(500, 300, 100, 50);
        userFrame.add(startButton);
        
        
        JTextField textInput = new JTextField();
        textInput.setBounds(100, 100, 400, 50);
        //userWindow.add(textInput);

        
        JLabel label = new JLabel();
        label.setText("aaaaaaaaaaaaaaaaaaaaaaa");
        JPanel panel = new JPanel();
        
        panel.add(label);
        userWindow.add(panel);
        userWindow.show();

      
        /*
        Scanner userInput = new Scanner(System.in);
        
        //storage
        String rooms[] = new String[10];
        String reserveRequest = null;
        
        System.out.println("question");
        reserveRequest = userInput.nextLine();
        
        int roomSelection = 0;
        
        if (rooms[roomSelection].isEmpty()) {
            rooms[roomSelection] = reserveRequest;
            System.out.println("result a");
            
        } else {
            System.out.println("result b");
        }
        */
    }
}
