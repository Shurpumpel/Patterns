package com.company;

public class Main {

    public static void main(String[] args) {
        Driver busDriver = Driver.createDriver(License.categoryD);

        Director director = new Director();
        director.transportBuilder = new BusBuilder();
        Car car = director.buildCar();
        car.setDriver(busDriver);

        Passenger passenger = new Passenger(typeOfPassenger.Adult);
        car.sitPassengertoCar(passenger);

        System.out.println(car);
    }
}
