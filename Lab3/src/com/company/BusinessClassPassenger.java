package com.company;

import java.util.ArrayList;

public class BusinessClassPassenger implements Human{
    ArrayList<Passenger> businessClassPassengers = new ArrayList<>();
    int maxFreeWeight = 35;
    int maxCount = 20;

    public void addBusinessClassPassenger(Passenger human){
        if((businessClassPassengers.size()<=maxCount)&&(human.classOfPassenger.equals(ClassOfPassenger.BusinessClass))){
            businessClassPassengers.add(human);
        }else{
            System.out.println("Error, not added");
        }
    }

    public void removeBusinessClassPassenger(Human human){
        businessClassPassengers.remove(human);
    }

    @Override
    public void ShowHuman() {
        for (Human human : businessClassPassengers){
            human.ShowHuman();
        }
    }
}
