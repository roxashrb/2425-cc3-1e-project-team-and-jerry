import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean active = true;
        String clientName;
        
        while (active) {
            System.out.println("set client type: \n1. Manager\n2.Customer");
            int clientTypeSelected = userInput.nextInt();
            userInput.nextLine();
            
            switch (clientTypeSelected) {
                case 1:
                Manager managerClient = new Manager();
                managerClient.setClientType("Manager");
                System.out.println("Set client name:");
                clientName = userInput.nextLine();
                managerClient.setClientName(clientName);
                    
                while (true) {
                    System.out.println("Choose operation:\n1.Read a reservation\n2.Edit a reservation\n3.Exit");
                    int task = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println("Input the name of the reservation to read: ");
                    String reservationToRead = userInput.nextLine();

                    switch (task) {
                        case 1:
                        managerClient.readReservation(reservationToRead);
                        break;
                        
                        case 2:
                        System.out.println("Enter new data");
                        
                        case 3:
                        break;
                    }
                    break;
                }
                    
                case 2:
                Customer customerClient = new Customer();
                customerClient.setClientType("Customer");
                System.out.println("Set client name:");
                clientName = userInput.nextLine();
                customerClient.setClientName(clientName);
                
                while (true) {
                    System.out.println("Choose task:\n1:Create a reservation");
                    int task = userInput.nextInt();
                    long timestamp = System.currentTimeMillis();
                    break;
                }
                break;
            }
        }
    }
}
