package com.company;

public class Main {

    public static void main(String[] args) {
        Car bus = new Bus();
        Car Taxi = new Taxi();

        Driver busDriver = new BusDriver(Driver.createDriver());
        Driver taxiDriver = new TaxiDriver(Driver.createDriver());
        bus.SetDriver(taxiDriver);


        Station station = new Station(15);
        station.sitToTransport(bus);

        Station station1 = new Station(10);
        station1.inOutPassengers(bus, 5);

        bus.CanCarMove();
        Taxi.CanCarMove();
    }

}
