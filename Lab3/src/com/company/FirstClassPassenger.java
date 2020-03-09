package com.company;

import java.util.ArrayList;

public class FirstClassPassenger implements Human{
    ArrayList<Passenger> firstClassPassengers = new ArrayList<>();
    int maxCount = 10;

    public void addFirstClassPassenger(Passenger human){
        if((firstClassPassengers.size()<=maxCount)&&(human.classOfPassenger.equals(ClassOfPassenger.FirstClass))){
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
