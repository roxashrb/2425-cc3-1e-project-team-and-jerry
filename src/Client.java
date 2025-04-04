package javaapplication45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Client {
    private String clientType;
    private String clientName;

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
    private String data;
    
    public String readReservation(String reservationName) {
        try {
            File reservation = new File(reservationName);
            
            if (reservation.exists()) {
                Scanner reader = new Scanner(reservation);
                
                while (reader.hasNextLine()) {
                    this.data = reader.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            this.data = "FileNotFoundException";
        }
        return this.data;
    }
        
    public void writeReservation(String reservation) {
        
        try {
            String reservationLog = reservation + "-" + clientType + "-" + clientName;
            File newReservation = new File(reservationLog);
            if (!newReservation.createNewFile()) {
                System.out.println("Reservation " + reservationLog + "created");
            } else {
                System.out.println("Reservation already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    
    
}
