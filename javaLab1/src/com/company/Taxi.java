package com.company;

public class Taxi implements Car {
    boolean IsDriver = false;
    int PassengersCount = 0;
    int maxPassengers = 4;
    TaxiDriver taxiDriver;

    public Taxi(){
        SetDriver();
    }

    //Посадить водителя в машину
    public void SetDriver() {
        IsDriver = true;
        taxiDriver.sitToCar();
    }

    //Посадить пассажирa в машину
    public void SetPassenger() {
        if((PassengersCount++)<=maxPassengers)
            PassengersCount++;
        else
            System.out.println("Taxi is full");
    }

    //проверка, разрешено ли машине ехать
    public boolean CanCarMove(){
        if ((IsDriver==true) && (PassengersCount>1) && (PassengersCount<maxPassengers)){
            System.out.println("Машина может ехать");
            return true;
        }
        System.out.println("Машина не может ехать");
        return false;
    }

    public int getPassengersCount(){
        return PassengersCount;
    }

    public int getMaxPassengersCount(){
        return maxPassengers;
    }

}
