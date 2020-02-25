package com.company;

enum License {
    categoryB, categoryD
};

public class Driver {
    License license;
    private static Driver instance;
    private Driver(License lic){
        this.license = lic;
    }
    public static Driver createDriver(License lic){
        if (instance == null){
            instance = new Driver(lic);
        }
        return instance;
    }
}
