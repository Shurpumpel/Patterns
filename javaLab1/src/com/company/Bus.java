package com.company;

public class Bus implements Car{
    boolean IsDriver = false;
    int PassengersCount = 0;
    int maxPassengers = 30;
    BusDriver driver;

    public Bus(){
        SetDriver();
    }

    //посадка водителя
    public void SetDriver() {
        IsDriver = true;
        driver = BusDriver.sitToCar();
    }

    //посадка пассажира в автобус
    public void SetPassenger() {
        if((PassengersCount+1)<=maxPassengers)
            PassengersCount++;
        else {
            System.out.println("Bus is full");
        }
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
