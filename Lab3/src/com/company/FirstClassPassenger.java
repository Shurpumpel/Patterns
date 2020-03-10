package com.company;

import java.util.ArrayList;

public class FirstClassPassenger implements Human{
    private ArrayList<Passenger> firstClassPassengers = new ArrayList<>();
    int maxCount = 10;

    public ArrayList<Passenger> getFirstClassPassengers(){
        return firstClassPassengers;
    }

    public void addFirstClassPassenger(Passenger human){
        if(human.classOfPassenger.equals(ClassOfPassenger.FirstClass)){
            firstClassPassengers.add(human);
        }else{
            System.out.println("Error, not added");
        }
    }

    public void removeFirstClassPassenger(Human human){
        firstClassPassengers.remove(human);
    }


    @Override
    public void ShowHuman() {
        for(Human human : firstClassPassengers){
            human.ShowHuman();
        }
    }
}
