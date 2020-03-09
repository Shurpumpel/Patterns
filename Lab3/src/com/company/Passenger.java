package com.company;

enum ClassOfPassenger{FirstClass, BusinessClass, EconomyClass}

public class Passenger implements Human{

    String name;
    ClassOfPassenger classOfPassenger;
    int weightOfLuggage;

    Passenger(String name, ClassOfPassenger classOfPassenger, int weightOfLuggage){
        this.name = name;
        this.classOfPassenger = classOfPassenger;
        this.weightOfLuggage = weightOfLuggage;
    }

    @Override
    public void ShowHuman() {
        System.out.println(name + " " + classOfPassenger + " " + weightOfLuggage);
    }
}

