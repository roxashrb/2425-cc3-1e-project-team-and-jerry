package hotelreservationsystem;

import java.util.Scanner;
import java.io.*;
public class Client {
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
        } catch (IOException e) {
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
        } catch (IOException e) {
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
                } else {
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
        } catch (IOException e) {
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
            } else {
                System.out.println("Error deleting file");
            }
        } catch (Exception e) {
            System.out.println("Error deleting file: " + e.getMessage());
        }
    }
}
