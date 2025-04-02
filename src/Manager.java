import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Manager extends Client {
    public void readReservation(String reservationName) {
        try {
            File reservation = new File(reservationName);
            
            if (reservation.exists()) {
                Scanner reader = new Scanner(reservation);
                
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    System.out.println(data);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        }
        
    }
}
