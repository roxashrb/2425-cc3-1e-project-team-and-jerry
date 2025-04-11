package hotelreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MainUI {
    // UI Components
    private JFrame frame;
    private JTextField clientNameField, clientPhoneField, fileNameField;
    private JTextArea fileContentArea;
    private Client client; // Reference to the Client object

    public MainUI(Client client) {
        this.client = client; // Use the existing Client object
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Hotel Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

    // Set background color for the frame
        frame.getContentPane().setBackground(Color.YELLOW); // Set background to yellow

    // Client Info Panel
        JPanel clientPanel = new JPanel(new GridLayout(2, 2));
        clientPanel.setBorder(BorderFactory.createTitledBorder("Client Information"));
        clientPanel.setBackground(Color.YELLOW); // Set background to yellow for panel

        clientPanel.add(new JLabel("Client Name:"));
        clientNameField = new JTextField();
        clientPanel.add(clientNameField);

        clientPanel.add(new JLabel("Client Phone:"));
        clientPhoneField = new JTextField();
        clientPanel.add(clientPhoneField);

        frame.add(clientPanel, BorderLayout.NORTH);

    // Action Buttons Panel
        JPanel actionPanel = new JPanel(new GridLayout(5, 1));
        actionPanel.setBorder(BorderFactory.createTitledBorder("Actions"));
        actionPanel.setBackground(Color.YELLOW); // Set background to yellow for panel

        JButton createButton = new JButton("Create Reservation");
        styleButton(createButton); // Style the button
        createButton.addActionListener(e -> createReservation());
        actionPanel.add(createButton);

        JButton readButton = new JButton("Read Reservation");
        styleButton(readButton); // Style the button
        readButton.addActionListener(e -> readReservation());
        actionPanel.add(readButton);

        JButton updateButton = new JButton("Update Reservation");
        styleButton(updateButton); // Style the button
        updateButton.addActionListener(e -> updateReservation());
        actionPanel.add(updateButton);

        JButton deleteButton = new JButton("Delete Reservation");
        styleButton(deleteButton); // Style the button
        deleteButton.addActionListener(e -> deleteReservation());
        actionPanel.add(deleteButton);

        JButton exitButton = new JButton("Exit");
        styleButton(exitButton); // Style the button
        exitButton.addActionListener(e -> System.exit(0));
        actionPanel.add(exitButton);

        frame.add(actionPanel, BorderLayout.WEST);

    // File Operations Panel
        JPanel filePanel = new JPanel(new GridBagLayout());
        filePanel.setBorder(BorderFactory.createTitledBorder("File Operations"));
        filePanel.setBackground(Color.YELLOW); // Set background to yellow for panel

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

    // Add File Name Field
        filePanel.add(new JLabel("File Name:"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0; // Make the text field expand horizontally
        fileNameField = new JTextField();
        filePanel.add(fileNameField, gbc);

    // Add File Content Area
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0; // Reset weight for label
        gbc.weighty = 0; // Reset vertical weight
        gbc.gridwidth = 1;
        filePanel.add(new JLabel("File Content:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0; // Allow the text area to expand vertically
        gbc.fill = GridBagConstraints.BOTH; // Make the text area fill the space
        gbc.gridwidth = 2; // Span across two columns
        fileContentArea = new JTextArea();
        filePanel.add(new JScrollPane(fileContentArea), gbc);

        frame.add(filePanel, BorderLayout.CENTER);

    // Display the frame
        frame.setVisible(true);
    }

// Utility method to style buttons
    private void styleButton(JButton button) {
        button.setBackground(Color.MAGENTA); // Set button color to purple
        button.setForeground(Color.WHITE);   // Set button text color to white
        button.setFocusPainted(false);       // Remove focus border
    }

    // Actions
    private void createReservation() {
        setClientDetails();

        Scanner scanner = new Scanner(fileNameField.getText() + "\n" + fileContentArea.getText());
        client.createReservation(scanner, client);
        JOptionPane.showMessageDialog(frame, "Reservation created successfully!");
    }

    private void readReservation() {
        setClientDetails();

        Scanner scanner = new Scanner(fileNameField.getText());
        client.readReservation(scanner, client);
    }

    private void updateReservation() {
        setClientDetails();

        Scanner scanner = new Scanner(fileNameField.getText() + "\n" + fileContentArea.getText());
        client.updateReservation(scanner, client);
    }

    private void deleteReservation() {
        setClientDetails();

        Scanner scanner = new Scanner(fileNameField.getText());
        client.deleteReservation(scanner, client);
        JOptionPane.showMessageDialog(frame, "Reservation deleted successfully!");
    }

    private void setClientDetails() {
        client.setClientName(clientNameField.getText());
        client.setClientPhone(clientPhoneField.getText());
    }

    // Main method to launch the UI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Client client = new Client();
            new MainUI(client);
        });
    }
}
