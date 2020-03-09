package com.company;

public class Pilot implements Human{

    String name;
    Pilot(String name){
        this.name = name;
    }

    @Override
    public void ShowHuman() {
        System.out.println("Pilot " + name);
    }
}
