import java.io.File;
import java.io.IOException;
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

            System.out.println("Choose operation:\n1. Create a reservation");
            int operation = userInput.nextInt();
            long timestamp = System.currentTimeMillis();
            switch (operation) {
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
