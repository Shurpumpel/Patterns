package com.company;

public class Main {

    public static void main(String[] args) {
	    Plane plane1 = new Plane(150, 50);
	    Plane plane2 = new Plane(200, 100);



        FirstClassPassenger firstClassPassenger = new FirstClassPassenger();
        BusinessClassPassenger businessClassPassenger = new BusinessClassPassenger();
        EconomyClassPassenger economyClassPassenger = new EconomyClassPassenger();

        for (int i = 0; i < 20; i++) {
            firstClassPassenger.addFirstClassPassenger(new Passenger("Vasya",
                    ClassOfPassenger.FirstClass, 15, (i+1)%10));
        }

        for (int i = 0; i < 40; i++) {
            businessClassPassenger.addBusinessClassPassenger(new Passenger("Vasya",
                    ClassOfPassenger.BusinessClass, 15, (i+1)%20));
        }

        for (int i = 0; i < 150; i++) {
            economyClassPassenger.addEconomyClassPassenger(new Passenger("Vasya",
                    ClassOfPassenger.EconomyClass, 15, (i+1)%150));
        }

        plane1.addPassengers(firstClassPassenger,businessClassPassenger,economyClassPassenger);
        plane1.removeLuggage();
        plane2.addPassengers(firstClassPassenger, businessClassPassenger, economyClassPassenger);
        plane2.removeLuggage();

        System.out.println("Plane1");
        System.out.println(plane1);
        plane1.ShowHuman();
        System.out.println("\nPlane2");
        System.out.println(plane2);
        plane2.ShowHuman();


    }
}
