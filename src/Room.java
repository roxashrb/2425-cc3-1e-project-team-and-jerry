public class Room {
    private String hotelName;
    private int roomNumber;
    private double roomPrice;
    private boolean roomIsReserved;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice() {
        this.roomPrice = roomPrice;
    }

    public boolean getRoomIsReserved() {
        return roomIsReserved;
    }

    public void setRoomIsReserved(boolean roomIsReserved) {
        this.roomIsReserved = roomIsReserved;
    }
}
