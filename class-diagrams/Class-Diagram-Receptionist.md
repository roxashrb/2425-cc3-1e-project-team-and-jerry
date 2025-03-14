```mermaid
---
title: Receptionist
---
classDiagram
    Employee --|> Receptionist
    Receptionist *-- Customer
    class Receptionist {
        -Customer customer
    }
```