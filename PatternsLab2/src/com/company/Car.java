package com.company;

public class Car {
    private int maxCountPassengers;
    private int priceAdult;
    private int priceKid;
    private int priceExempt;
    public Driver carDriver;
    public boolean isDriver = false;
    public int passengersInCar = 0;
    public boolean carCanMove = false;
    public License needLicense;

    void setMaxCountPassengers(int m){
        this.maxCountPassengers = m;
    }

    void setPriceAdult(int p){
        this.priceAdult = p;
    }

    void setPriceKid(int p){
        this.priceKid = p;
    }

    void setPriceExempt(int p){
        this.priceExempt = p;
    }

    void setDriver(){
        this.carDriver = Driver.sitToCar(needLicense);
        this.isDriver= true;
    }

    void inPassengerToCar(){
        this.passengersInCar = this.passengersInCar + 1;
        setCanCarMove();
    }

    void outPassengersFromCar(){
        this.passengersInCar = this.passengersInCar-1;
        setCanCarMove();
    }

    void setCanCarMove(){
        if ((isDriver)&&(passengersInCar>0)){
            this.carCanMove = true;
        }else{
            this.carCanMove = false;
        }
    }

    public String toString(){
        return "MaxCount = " + maxCountPassengers + "\n" +
                "PassengersInCar = " + passengersInCar + "\n" +
                "IsDriver = " + isDriver + "\n" +
                "CarCanMove = " + carCanMove;
    }
}
