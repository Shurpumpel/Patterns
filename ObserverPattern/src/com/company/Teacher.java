package com.company;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements Observed {
    private List<Observer> observers = new ArrayList<>();

    private boolean isCreatedAcademicalPerformance;

    public String name;

    public Teacher(boolean isCreatedAcademicalPerformance, String name) {
        this.isCreatedAcademicalPerformance = isCreatedAcademicalPerformance;
        this.name = name;
    }

    public boolean isCreatedAcademicalPerformance() {
        return isCreatedAcademicalPerformance;
    }

    public void setCreatedAcademicalPerformance(boolean createdAcademicalPerformance) {
        isCreatedAcademicalPerformance = createdAcademicalPerformance;
    }

    public void CreateAcademicalPerformance(){
        this.isCreatedAcademicalPerformance = true;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer a) {
        this.observers.add(a);
    }

    @Override
    public void removeObserver(Observer a) {
        this.observers.remove(a);
    }

    @Override
    public void notifyObserver() {
        for (Observer a : observers){
            a.Update(this);
        }
    }
}
