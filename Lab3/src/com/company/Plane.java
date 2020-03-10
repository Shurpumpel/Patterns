package com.company;

import java.util.ArrayList;

public class Plane implements Human{
    private int maxWeight;
    private int maxCountPilot = 2;
    private int maxCountStewardess = 6;
    private int maxSeat;

    private int countPilotsOnBoard = 0;
    private int countStewardessesOnBoard = 0;
    private int countPassengersOnBoard = 0;

    private int countFirstClass = 0;
    private int countBusinessClass = 0;
    private int countEconomyClass = 0;

    public ArrayList<Human> AllOnBoard = new ArrayList<>();

    public ArrayList<Human> removedLuggageHuman = new ArrayList<>();

    public void addPilot(Pilot pilot){
        countPilotsOnBoard++;
        if (countPilotsOnBoard <=maxCountPilot) {
            this.AllOnBoard.add(pilot);
        }
        else
            System.out.println("Pilots full");
    }

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
        int i=0;
        for (Human pass : firstClassPassenger.getFirstClassPassengers()) {
            if(i==10)
                break;
            AllOnBoard.add(pass);
            countFirstClass++;
            i++;
        }
        for(Human pass : AllOnBoard){
            if(firstClassPassenger.getFirstClassPassengers().contains(pass))
                firstClassPassenger.removeFirstClassPassenger(pass);
        }

        i=0;
        for (Human pass : businessClassPassenger.getBusinessClassPassengers()) {
            if(i==20)
                break;
            AllOnBoard.add(pass);
            countBusinessClass++;
            i++;
        }
        for(Human pass : AllOnBoard){
            if(businessClassPassenger.getBusinessClassPassengers().contains(pass))
                businessClassPassenger.removeBusinessClassPassenger(pass);
        }

        i=0;
        for (Human pass : economyClassPassenger.getEconomyClassPassengers()) {
            if(i == maxSeat - 30)
                break;
            AllOnBoard.add(pass);
            countEconomyClass++;
            i++;
        }
        for(Human pass : AllOnBoard){
            if(economyClassPassenger.getEconomyClassPassengers().contains(pass))
                economyClassPassenger.removeEconomyClassPassenger(pass);
        }

        for(Human pass :AllOnBoard){
            if(pass.getClass()==Passenger.class)
                countPassengersOnBoard++;
        }
    }

    public void removePassenger(int seat){
        for(Human pass : AllOnBoard){
            if((pass instanceof Passenger)&&(((Passenger) pass).seatInPlane==seat)){
                AllOnBoard.remove(pass);
            }
        }
    }

    //конструктор для создания самолета
    public Plane(int maxWeight, int maxSeat){
        this.maxWeight = maxWeight;
        this.maxSeat = maxSeat;
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
                "CountFirstClass: " + countFirstClass + "\n"+
                "CountBusinessClass: " + countBusinessClass + "\n"+
                "CountEconomyClass: " + countEconomyClass + "\n"+
                "Overweight: "+getOverWeight()+"\n"+
                "RemovedLuggageCount: "+removedLuggageHuman.size()+"\n";
        return str;
    }

    public Human findBySeat(int num){
        for (Human pass : AllOnBoard) {
            if ((pass instanceof Passenger)&&(((Passenger) pass).seatInPlane == num)){
                return pass;
            }
        }
        return null;
    }

    @Override
    public void ShowHuman() {
        for (Human human : AllOnBoard){
            human.ShowHuman();
        }
    }

}
