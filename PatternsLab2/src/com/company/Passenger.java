package com.company;

enum typeOfPassenger{Kid, Adult, Exempt}

public class Passenger {
    typeOfPassenger type;
    public Passenger(typeOfPassenger type){
        this.type = type;
    }
}
