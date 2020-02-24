package com.company;

public class Main {

    public static void main(String[] args) {
        Bus bus = new Bus();

        Station station = new Station(15);
        station.sitToTransport(bus);

        bus.CanCarMove();
    }


}
