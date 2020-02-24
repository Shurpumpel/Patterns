package com.company;

public class Station {

    int PassengersOnStation;

    public Station(int count){
        PassengersOnStation = count;
    }

    public void sitToTransport(Car car){
        int countOfSat = 0;
        for (int i=0;i<PassengersOnStation;i++){
            if (car.getPassengersCount()<car.getMaxPassengersCount()){
                car.SetPassenger();
                countOfSat++;
            }
            else {
                break;
            }
        }
        System.out.println("Сели "+countOfSat+" человек");
    }

    public static Car getTypeOfCar(String typeOfCar){
        switch (typeOfCar){
            case "Bus":
                return new Bus();
            case "Taxi":
                return new Taxi();
            default:
                throw new RuntimeException("Unsupported type of car");
        }
    }
}
