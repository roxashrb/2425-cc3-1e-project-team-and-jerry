```mermaid
---
title: Reception
---
classDiagram
    Employee --|> Reception
    Reception *-- Customer
    class Reception {
        -Customer customer
    }
```
