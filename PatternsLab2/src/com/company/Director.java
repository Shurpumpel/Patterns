package com.company;

public class Director {
    TransportBuilder transportBuilder;

    void setTransportBuilder(TransportBuilder b){this.transportBuilder = b;}

    Car buildCar(){
        transportBuilder.createCar();
        transportBuilder.buildMaxCountPassengers();
        transportBuilder.buildPriceAdult();
        transportBuilder.buildPriceKid();
        transportBuilder.buildPriceExempt();
        Car car = transportBuilder.getCar();
        return car;
    }
}
