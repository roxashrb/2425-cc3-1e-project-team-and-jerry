import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Crud {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Create File");
        System.out.println("2. Read File");
        System.out.println("3. Update File");
        System.out.println("4. Delete File");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        switch (option) {
            case 1:
                createFile(scanner);
                break;
            case 2:
                readFile(scanner);
                break;
            case 3:
                updateFile(scanner);
                break;
            case 4:
                deleteFile(scanner);
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public static void createFile(Scanner scanner) {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.print("Enter text to write to file: ");
            String text = scanner.nextLine();
            writer.write(text);
            System.out.println("File created successfully");
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    public static void readFile(Scanner scanner) {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void updateFile(Scanner scanner) {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        System.out.print("Enter line number to update: ");
        int lineNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over
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
            // replace original file with temporary file
            java.io.File originalFile = new java.io.File(fileName);
            java.io.File tempFile = new java.io.File(fileName + ".tmp");
            originalFile.delete();
            tempFile.renameTo(originalFile);
            System.out.println("File updated successfully");
        } catch (IOException e) {
            System.out.println("Error updating file: " + e.getMessage());
        }
    }

    public static void deleteFile(Scanner scanner) {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
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