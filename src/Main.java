package javaapplication45;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String clientName;
        int clientTask = 0;
        
        while (true) {
            System.out.println("set client type: \n1. Manager\n2. Customer");
            int clientType = userInput.nextInt();
            userInput.nextLine();
            
            if (clientType == 1) {
                Manager managerClient = new Manager();
                managerClient.setClientType("Manager");
                System.out.println("Set client name:");
                clientName = userInput.nextLine();
                managerClient.setClientName(clientName);
                
                while (true) {
                    System.out.println("Choose operation:\n1.Read a reservation\n2.Edit a reservation\n3.Exit");
                    clientTask = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println("Input the name of the reservation to read: ");
                    String reservationToRead = userInput.nextLine();

                    switch (clientTask) {
                        case 1:
                            managerClient.readReservation(reservationToRead);
                            System.out.println(managerClient.readReservationResult());
                            break;
                        
                        case 2:
                            System.out.println("Enter new data");
                            break;
                        
                        case 3:
                            break;
                    }
                }
                if (clientTask == 3) {
                        break;
                }
            }
            else if (clientType == 2) {
                Customer customerClient = new Customer();
                customerClient.setClientType("Customer");
                System.out.println("Set client name:");
                clientName = userInput.nextLine();
                customerClient.setClientName(clientName);
            }
            
            /*
            
            switch (clientType) {
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
                            System.out.println(managerClient.readReservationResult());
                            break;
                        
                        case 2:
                            System.out.println("Enter new data");
                            break;
                        
                        case 3:
                            break;
                    }
                    
                    if (task == 3) {
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
            break;*/
        }
    }
}
