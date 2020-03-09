package com.company;

import java.util.ArrayList;

public class EconomyClassPassenger implements Human {
    ArrayList<Passenger> economyClassPassengers = new ArrayList<>();
    int maxFreeWeight = 20;
    int maxCount = 150;

    public void addEconomyClassPassenger(Passenger human){
        if((economyClassPassengers.size()<=maxCount)&&(human.classOfPassenger.equals(ClassOfPassenger.EconomyClass))){
            economyClassPassengers.add(human);
        }else{
            System.out.println("Error, not added");
        }
    }

    public void removeEconomyClassPassenger(Human human){
        economyClassPassengers.remove(human);
    }
    @Override
    public void ShowHuman() {
        for (Human human : economyClassPassengers){
            human.ShowHuman();
        }
    }
}
