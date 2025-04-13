/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication31;

/**
 *
 * @author Tricia Bonilla
 */
import javax.swing.*;
import java.awt.*;

public class LoginUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginUI() {
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Hotel Reservation System - Login");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));
        frame.getContentPane().setBackground(Color.YELLOW);

        JPanel userPanel = new JPanel(new FlowLayout());
        userPanel.setBackground(Color.YELLOW);
        userPanel.add(new JLabel("Username:"));
        usernameField = new JTextField(20);
        userPanel.add(usernameField);

        JPanel passPanel = new JPanel(new FlowLayout());
        passPanel.setBackground(Color.YELLOW);
        passPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(20);
        passPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.MAGENTA);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(e -> authenticate());

        frame.add(userPanel);
        frame.add(passPanel);
        frame.add(new JPanel()); // Spacer
        frame.add(loginButton);

        frame.setVisible(true);
    }

    private void authenticate() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("1234")) {
            frame.dispose();
            Client client = new Client();
            MainUI mainUI = new MainUI(client);
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginUI::new);
    }
}
