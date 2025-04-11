import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        boolean active = true;
        
        System.out.println("Hotel Reservation System");
        
        while (true) {
            System.out.print("Enter client name: ");
            client.setClientName(scanner.nextLine());
            System.out.print("Enter client phone number: ");
            client.setClientPhone(scanner.nextLine());
            break;
        }
        
        while (active) {
            System.out.println("Welcome, " + client.getClientName() + ".\nContact: " + client.getClientPhone());
            System.out.println("Reminder that you can only create, read, update, and delete your OWN reservations.");
            
            System.out.println("1. Create Reservation");
            System.out.println("2. Read Reservation");
            System.out.println("3. Update Reservation");
            System.out.println("4. Delete Reservation");
            System.out.println("0. Exit Program");
            System.out.print("Choose an option: ");
            
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    System.out.println("Exit confirmed");
                    active = false;
                    break;
                case 1:
                    client.createReservation(scanner, client);
                    break;
                case 2:
                    client.readReservation(scanner, client);
                    break;
                case 3:
                    client.updateReservation(scanner, client);
                    break;
                case 4:
                    client.deleteReservation(scanner, client);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
    
    //classes and methods (too lazy to put these in different files bruhhh)
    public static class Client {
        private String clientName;
        private String clientPhone;

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }
        
        public String getClientPhone() {
            return clientPhone;
        }

        public void setClientPhone(String clientPhone) {
            this.clientPhone = clientPhone;
        }
        
        public void createReservation(Scanner scanner, Client client) {
            System.out.print("Enter file name: " + client.getClientName() + "-" + client.getClientPhone() + "-");
            String fileName = client.getClientName() + "-" + client.getClientPhone() + "-" + scanner.nextLine() + ".txt";
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                System.out.print("Enter text to write to file: ");
                String text = scanner.nextLine();
                writer.write(text);
                System.out.println("File created successfully");
            }
            catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }

        public void readReservation(Scanner scanner, Client client) {
            System.out.print("Enter file name: " + client.getClientName() + "-" + client.getClientPhone() + "-");
            String fileName = client.getClientName() + "-" + client.getClientPhone() + "-" + scanner.nextLine() + ".txt";
        
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }

        public void updateReservation(Scanner scanner, Client client) {
            System.out.print("Enter file name: " + client.getClientName() + "-" + client.getClientPhone() + "-");
            String fileName = client.getClientName() + "-" + client.getClientPhone() + "-" + scanner.nextLine() + ".txt";
            System.out.print("Enter line number to update: ");
            int lineNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new text: ");
            String newText = scanner.nextLine();
            
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".tmp"))) {
                String line;
                int i = 1;
                
                while ((line = reader.readLine()) != null) {
                    if (i == lineNumber) {
                        writer.write(newText);
                    }
                    else {
                        writer.write(line);
                    }
                    writer.newLine();
                    i++;
                }

                java.io.File originalFile = new java.io.File(fileName);
                java.io.File tempFile = new java.io.File(fileName + ".tmp");
                originalFile.delete();
                tempFile.renameTo(originalFile);
                System.out.println("File updated successfully");
            }
            catch (IOException e) {
                System.out.println("Error updating file: " + e.getMessage());
            }
        }

        public void deleteReservation(Scanner scanner, Client client) {
            System.out.print("Enter file name: " + client.getClientName() + "-" + client.getClientPhone() + "-");
            String fileName = client.getClientName() + "-" + client.getClientPhone() + "-" + scanner.nextLine() + ".txt";
            
            try {
                java.io.File file = new java.io.File(fileName);
                
                if (file.delete()) {
                    System.out.println("File deleted successfully");
                }
                else {
                    System.out.println("Error deleting file");
                }
            }
            catch (Exception e) {
                System.out.println("Error deleting file: " + e.getMessage());
            }
        }
    }
    
    public static class MainUI {
        private JFrame frame;
        private JTextField clientNameField;
        private JTextField clientPhoneField;
        private JTextField fileNameField;
        private JTextArea fileContentArea;
    }
}
