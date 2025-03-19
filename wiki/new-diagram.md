```mermaid
---
Title: Hotel Reservation System
---
classDiagram
    class Client {
        -String ClientType
        -int userId
        -String userName
        -String userToken
        -boolean loginStatus
    }

    Client --|> Hotel
    class Hotel {
        +reserveRoom()
    }

    Client --|> Customer
    class Customer {
        +reserveRequest()
    }

    Hotel --* Rooms
    class Rooms {
        -int roomHotelId
        -int roomNumber
        -double roomPrice
        -String roomType
    }

    class LoginHelper {
        +login()
        +logout()
    }

    class Main {
    }
    
```
