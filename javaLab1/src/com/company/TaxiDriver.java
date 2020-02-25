package com.company;

public class TaxiDriver extends Driver {
    private static TaxiDriver instance; // для определения, существет ли экземпляр данного класса

    Driver taxiDriver;

    //ставим водителю категорию прав
    TaxiDriver(Driver driver){
        taxiDriver = driver;
        license = License.BCategory;
    }
}
