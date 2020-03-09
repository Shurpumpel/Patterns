package com.company;

public class Main {

    public static void main(String[] args) {
	    Plane plane = new Plane(150);

	    Pilot pilot1 = new Pilot("Vasily");
        Pilot pilot2 = new Pilot("Gennady");

        Stewardess stewardess1 = new Stewardess("Svetlana");
        Stewardess stewardess2 = new Stewardess("Galina");
        Stewardess stewardess3 = new Stewardess("Maria");
        Stewardess stewardess4 = new Stewardess("Natalia");
        Stewardess stewardess5 = new Stewardess("Ekaterina");
        Stewardess stewardess6 = new Stewardess("Olga");

        Passenger passenger1 = new Passenger("Ashot", ClassOfPassenger.FirstClass, 40);
        Passenger passenger2 = new Passenger("Ashot", ClassOfPassenger.FirstClass, 40);
        Passenger passenger3 = new Passenger("Ashot", ClassOfPassenger.BusinessClass, 40);
        Passenger passenger4 = new Passenger("Ashot", ClassOfPassenger.BusinessClass, 40);
        Passenger passenger5 = new Passenger("Ashot", ClassOfPassenger.EconomyClass, 40);
        Passenger passenger6 = new Passenger("Ashot", ClassOfPassenger.EconomyClass, 40);


        FirstClassPassenger firstClassPassenger = new FirstClassPassenger();
        BusinessClassPassenger businessClassPassenger = new BusinessClassPassenger();
        EconomyClassPassenger economyClassPassenger = new EconomyClassPassenger();

        firstClassPassenger.addFirstClassPassenger(passenger1);
        firstClassPassenger.addFirstClassPassenger(passenger2);

        businessClassPassenger.addBusinessClassPassenger(passenger3);
        businessClassPassenger.addBusinessClassPassenger(passenger4);

        economyClassPassenger.addEconomyClassPassenger(passenger5);
        economyClassPassenger.addEconomyClassPassenger(passenger6);

        plane.addPilot(pilot1);
        plane.addPilot(pilot2);
        plane.addStewardess(stewardess1);
        plane.addStewardess(stewardess2);
        plane.addStewardess(stewardess3);
        plane.addStewardess(stewardess4);
        plane.addStewardess(stewardess5);
        plane.addStewardess(stewardess6);
        plane.addPassengers(firstClassPassenger,businessClassPassenger,economyClassPassenger);

        System.out.println(plane);
        System.out.println(plane.isPlaneReadyToFly());

        plane.removeLuggage();
        System.out.println(plane);
        System.out.println(plane.isPlaneReadyToFly());

        plane.ShowHuman();
    }
}
