package com.company;

public class Taxi implements Car {
    boolean IsDriver = false;
    int PassengersCount = 0;
    int maxPassengers = 4;
    TaxiDriver taxiDriver;

    //Посадить водителя в машину
    public void SetDriver(Driver driver) {
        if (driver.license == License.BCategory){
            this.taxiDriver = (TaxiDriver) driver;
            IsDriver = true;
        }else {
            System.out.println("Not this driver");
            IsDriver = false;
        }
    }

    //Посадить пассажирa в машину
    public void SetPassenger() {
        if((PassengersCount+1)<=maxPassengers)
            PassengersCount++;
        else
            System.out.println("Taxi is full");
    }

    @Override
    public void OutPassenger() {
        if(PassengersCount>0) {
            PassengersCount--;
        }else{
            System.out.println("there not passenger");
        }
    }

    //проверка, разрешено ли машине ехать
    public boolean CanCarMove(){
        if ((IsDriver==true) && (PassengersCount>1) && (PassengersCount<=maxPassengers)){
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
