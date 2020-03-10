package com.company;

import java.util.ArrayList;

public class BusinessClassPassenger implements Human{
    private ArrayList<Passenger> businessClassPassengers = new ArrayList<>();
    private int maxFreeWeight = 35;

    public ArrayList<Passenger> getBusinessClassPassengers(){
        return businessClassPassengers;
    }

    public void addBusinessClassPassenger(Passenger human){
        if((human.classOfPassenger.equals(ClassOfPassenger.BusinessClass))){
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
