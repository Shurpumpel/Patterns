package com.company;

public interface Car {
    int getPassengersCount();
    int getMaxPassengersCount();
    void SetDriver(Driver driver);
    void SetPassenger();
    void OutPassenger();
    boolean CanCarMove();
}
