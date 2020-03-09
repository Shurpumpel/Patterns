package com.company;

public class Stewardess implements Human {
    String name;

    Stewardess(String name){
        this.name = name;
    }
    @Override
    public void ShowHuman() {
        System.out.println("Stewardess "+name);
    }
}
