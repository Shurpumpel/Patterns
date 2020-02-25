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

    public void outFromTransport(Car car, int count){
        int countOfSat = 0;
        for (int i=0;i<count;i++){
            car.OutPassenger();
            countOfSat++;
        }
        System.out.println("вышли "+countOfSat+" человек");
    }


    public void inOutPassengers(Car car, int count){
        outFromTransport(car, count);
        sitToTransport(car);
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
