package com.company;

import java.util.ArrayList;

public class EconomyClassPassenger implements Human {
    private ArrayList<Passenger> economyClassPassengers = new ArrayList<>();
    private int maxFreeWeight = 20;

    public ArrayList<Passenger> getEconomyClassPassengers(){
        return economyClassPassengers;
    }

    public void addEconomyClassPassenger(Passenger human){
        if(human.classOfPassenger.equals(ClassOfPassenger.EconomyClass)){
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
