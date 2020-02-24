package com.company;

public class TaxiDriver extends Driver {
    private static TaxiDriver instance; // для определения, существет ли экземпляр данного класса

    //ставим водителю категорию прав
    private TaxiDriver(){
        license = License.BCategory;
    }

    //реализуем посадку водителя в машину, при этом водитель может быть толко один
    public static TaxiDriver sitToCar(){
        if (instance == null)
            instance = new TaxiDriver();
        return instance;
    }
}
