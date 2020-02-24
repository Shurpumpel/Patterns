package com.company;

public class BusDriver extends Driver {
    private static BusDriver instance; //ссыллка на экземпляр класса

    //выставляем категорию вождения
    private BusDriver(){
        license = License.DCategory;
    }

    //реализуем посадку в машину, при этом водитель может быть только один
    public static BusDriver sitToCar(){
        if (instance == null)
            instance = new BusDriver();
        return instance;
    }
}
