package com.company;

public class BusDriver extends Driver {

    private static BusDriver instance; //ссыллка на экземпляр класса

    public String name;
    Driver busDriver;
    //выставляем категорию вождения
    public BusDriver(Driver driver){
        this.name = name;
        busDriver = driver;
        license = License.DCategory;
    }

}
