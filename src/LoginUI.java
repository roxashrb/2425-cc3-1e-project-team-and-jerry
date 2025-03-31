import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoginUI {
    public static void main(String[] args) {
       
        JFrame loginFrame = new JFrame("Login Page");
        loginFrame.setSize(400, 300);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        JPanel panel = new JPanel();
        loginFrame.add(panel);
        panel.setLayout(new GridLayout(3, 2));

        
        JLabel usernameLabel = new JLabel("Username: ");
        JTextField usernameField = new JTextField(20);
        
        
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField(20);

        
        JButton loginButton = new JButton("Login");

        
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        
        loginButton.addActionListener((ActionEvent e) -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            
            
            if ("admin".equals(username) && "MasterJerry".equals(password)) {
                JOptionPane.showMessageDialog(loginFrame, "Login successful!");
                loginFrame.setVisible(false);  
                
                
                showClientSelectionPage();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid login, please try again.");
            }
        });

        
        loginFrame.setVisible(true);
    }

    
    public static void showClientSelectionPage() {
        Scanner userInput = new Scanner(System.in);
        boolean active = true;
        String clientName;
        
        while (active) {
            System.out.println("Set client type: \n1. Manager\n2. Customer");
            int clientType = userInput.nextInt();
            userInput.nextLine();
            switch (clientType) {
                case 1:
                    Manager managerClient = new Manager();
                    managerClient.setClientType("Manager");
                    System.out.println("Set client name:");
                    clientName = userInput.nextLine();
                    managerClient.setClientName(clientName);
                    break;
                case 2:
                    Customer customerClient = new Customer();
                    customerClient.setClientType("Customer");
                    System.out.println("Set client name:");
                    clientName = userInput.nextLine();
                    customerClient.setClientName(clientName);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            System.out.println("Choose operation:\n1. Create a reservation");
            int operation = userInput.nextInt();
            switch (operation) {
                case 1:
                    try {
                        File reservation = new File("filename.txt");
                        if (reservation.createNewFile()) {
                            System.out.println("File created: " + reservation.getName());
                        } else {
                            System.out.println("File already exists.");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                    }
                    break;
            }
        }
    }
}