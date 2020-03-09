package com.company;

import java.util.ArrayList;

public class Plane implements Human{
    private int maxWeight;
    private int maxCountPilot = 2;
    private int maxCountStewardess = 6;

    private int countPilotsOnBoard = 0;
    private int countStewardessesOnBoard = 0;
    private int countPassengersOnBoard = 0;

    public ArrayList<Human> AllOnBoard = new ArrayList<>();

    public ArrayList<Human> removedLuggageHuman = new ArrayList<>();

    //посадить в самолет пилота
    public void addPilot(Pilot pilot){
        countPilotsOnBoard++;
        if (countPilotsOnBoard <=maxCountPilot) {
            this.AllOnBoard.add(pilot);
        }
        else
            System.out.println("Pilots full");
    }

    //посадить в самолет стюардессу
    public void addStewardess(Stewardess stewardess){
        countStewardessesOnBoard++;
        if(countStewardessesOnBoard <=maxCountStewardess) {
            this.AllOnBoard.add(stewardess);
        }
        else
            System.out.println("Stewardesses full");
    }

    //посадить в самолет всех пассажиров
    public void addPassengers(FirstClassPassenger firstClassPassenger,
                              BusinessClassPassenger businessClassPassenger,
                              EconomyClassPassenger economyClassPassenger){
        AllOnBoard.addAll(firstClassPassenger.firstClassPassengers);
        AllOnBoard.addAll(businessClassPassenger.businessClassPassengers);
        AllOnBoard.addAll(economyClassPassenger.economyClassPassengers);
        for(Human pass :AllOnBoard){
            if(pass.getClass()==Passenger.class)
                countPassengersOnBoard++;
        }
    }

    //конструктор для создания самолета
    public Plane(int maxWeight){
        this.maxWeight = maxWeight;
    }

    //сеттер максимального веса самолета
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    //подсчет суммы веса всего багажа
    int getSumWeight(){
        int sumWeight = 0;
        for (Human passenger : AllOnBoard){
            if (passenger.getClass()==Passenger.class){
                sumWeight+=((Passenger) passenger).weightOfLuggage;
            }
        }
        return sumWeight;
    }

    int getOverWeight(){
        if(maxWeight >= getSumWeight()) {
            return 0;
        }else{
            return getSumWeight()-maxWeight;
        }
    }

    //снимаем багаж с рейса
    public void removeLuggage(){
        for(Human pass : AllOnBoard){
            if (pass.getClass().equals(Passenger.class)) {
                if (((Passenger) pass).classOfPassenger.equals(ClassOfPassenger.EconomyClass)){
                    removedLuggageHuman.add(pass);
                    ((Passenger) pass).weightOfLuggage = 0;
                }
            }
        }
    }

    public boolean isPlaneReadyToFly(){
        if(maxWeight >= getSumWeight() &&
                maxCountPilot==countPilotsOnBoard &&
                maxCountStewardess==countStewardessesOnBoard){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        String str="";
        str+="Count of pilots: "+ countPilotsOnBoard +"\n"+
                "Count of stewardesses: "+countStewardessesOnBoard+"\n"+
                "Count of passengers: "+countPassengersOnBoard+"\n"+
                "Overweight: "+getOverWeight()+"\n"+
                "RemovedLuggageCount: "+removedLuggageHuman.size()+"\n";
        return str;
    }


    @Override
    public void ShowHuman() {
        for (Human human : AllOnBoard){
            human.ShowHuman();
        }
    }
}
