import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //interface
        JFrame userWindow = new JFrame("Reserve");
        
        JTextField textInput = new JTextField();
        textInput.setBounds(100, 100, 400, 50);
        //userWindow.add(textInput);
        
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(175, 500, 250, 50);
        userWindow.add(confirmButton);
        
        userWindow.setSize(600, 600);
        userWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userWindow.setLayout(null);
        userWindow.setVisible(true);
        
        JLabel label = new JLabel();
        label.setText("aaaaaaaaaaaaaaaaaaaaaaa");
        JPanel panel = new JPanel();
        
        panel.add(label);
        userWindow.add(panel);
        userWindow.show();

      
        //input
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
    }
}
