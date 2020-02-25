package com.company;

public class Car {
    private int maxCountPassengers;
    private int priceAdult;
    private int priceKid;
    private int priceExempt;
    public Driver carDriver;
    public boolean isDriver = false;
    public int passengersKids = 0;
    public int passengersAdults = 0;
    public int passengersExempts = 0;
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

    void setDriver(Driver driver){
        if(driver.license == needLicense){
            this.carDriver = driver;
            this.isDriver= true;
        }else{
            System.out.println("Not this driver");
            this.isDriver = false;
        }
    }

    void inKidPassengerToCar(){
        this.passengersKids = this.passengersKids + 1;
        this.passengersInCar = this.passengersInCar +1;
        setCanCarMove();
    }

    void inAdultPassengerToCar(){
        this.passengersAdults = this.passengersAdults + 1;
        this.passengersInCar = this.passengersInCar +1;
        setCanCarMove();
    }
    void outExemptPassengerToCar(){
        this.passengersExempts = this.passengersExempts + 1;
        this.passengersInCar = this.passengersInCar +1;
        setCanCarMove();
    }

    void outKidPassengerToCar(){
        this.passengersKids = this.passengersKids - 1;
        this.passengersInCar = this.passengersInCar -1;
        setCanCarMove();
    }

    void outAdultPassengerToCar(){
        this.passengersKids = this.passengersKids - 1;
        this.passengersInCar = this.passengersInCar -1;
        setCanCarMove();
    }
    void inExemptPassengerToCar(){
        this.passengersExempts = this.passengersExempts - 1;
        this.passengersInCar = this.passengersInCar -1;
        setCanCarMove();
    }

    void sitPassengertoCar(Passenger passenger){
        if (passenger.type == typeOfPassenger.Adult){
            this.inAdultPassengerToCar();
        }
        if (passenger.type == typeOfPassenger.Kid){
            this.inKidPassengerToCar();
        }
        if (passenger.type == typeOfPassenger.Exempt){
            this.inExemptPassengerToCar();
        }

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
                "CountKids = " + passengersKids +"\n" +
                "CountAdults = " + passengersAdults +"\n" +
                "CountExempts = " + passengersExempts +"\n" +
                "CarCanMove = " + carCanMove;
    }
}
