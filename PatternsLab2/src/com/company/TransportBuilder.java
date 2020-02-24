package com.company;

abstract class TransportBuilder {
    Car car;
    void createCar(){
        this.car = new Car();
    }

    abstract void buildMaxCountPassengers();
    abstract void buildPriceAdult();
    abstract void buildPriceKid();
    abstract void buildPriceExempt();
    abstract void setNeedLicense();

    Car getCar(){
        return car;
    }
}
