package com.company;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();
        director.transportBuilder = new BusBuilder();
        Car car = director.buildCar();
        car.setDriver();
        for (int i = 0; i < 15; i++) {
            car.inPassengerToCar();
        }
        for (int i = 0; i < 10 ; i++) {
            car.outPassengersFromCar();
        }
        System.out.println(car);
    }
}
