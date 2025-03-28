import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean active = true;
        while (boolean) {
            System.out.println("set client type: \n1. Manager\n2.Customer");
            int clientType = userInput.nextInt();
            switch (clientType) {
                case 1:
                    Manager managerClient = new Manager();
                    setClientType("Manager");
                    break;
                case 2:
                    Customer customerClient = new Customer();
                    setClientType("Customer");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
