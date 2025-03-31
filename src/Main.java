import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean active = true;
        String clientName;
        String clientType;
        
        while (active) {
            System.out.println("set client type: \n1. Manager\n2.Customer");
            int clientTypeSelected = userInput.nextInt();
            userInput.nextLine();
            
            switch (clientType) {
                case 1:
                    Manager managerClient = new Manager();
                    managerClient.setClientType("Manager");
                    clientType = managerClient.getClientType();
                    System.out.println("Set client name:");
                    clientName = userInput.nextLine();
                    managerClient.setClientName(clientName);
                    break;
                    
                case 2:
                    Customer customerClient = new Customer();
                    customerClient.setClientType("Customer");
                    clientType = customerClient.getClientType();
                    System.out.println("Set client name:");
                    clientName = userInput.nextLine();
                    customerClient.setClientName(clientName);
                    break;
                    
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            if (clientType.equals("Manager")) {
                System.out.println("Choose operation:\n1.Read a reservation");
                int task = userInput.nextInt();
                userInput.nextLine();
                System.out.println("Input the name of the reservation to read: ");
                String filenameToRead = userInput.nextLine();

                switch (task) {
                    case 1:
                        try {
                            File reservationToRead = new File(filenameToRead);
                            
                            while (userInput.hasNextLine()) {
                                String data = userInput.nextLine();
                                System.out.println(data);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                }
            } else {
                System.out.println("Choose task:\n1:Create a reservation");
                int task = userInput.nextInt();
                long timestamp = System.currentTimeMillis();
                
                switch (task) {
                    case 1:
                        try {
                            File reservation = new File(clientType + "-" + timestamp);
                            if (reservation.createNewFile()) {
                                System.out.println("File created: " + reservation.getName());
                            } else {
                                System.out.println("File already exists.");
                            }
                        } catch (IOException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }
                    break;
            }
        }
    }
}
