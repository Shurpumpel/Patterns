package com.company;

enum License {BCategory, DCategory}

public class Driver {
    License license;
    private static Driver instance;

    //реализуем посадку в машину, при этом водитель может быть только один
    public static Driver createDriver(){
        if (instance == null)
            instance = new Driver();
        return instance;
    }
}
