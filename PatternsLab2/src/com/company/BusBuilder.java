package com.company;

public class BusBuilder extends TransportBuilder {

    void buildMaxCountPassengers() {
        car.setMaxCountPassengers(30);
    }

    void buildPriceAdult() {
        car.setPriceAdult(40);
    }

    void buildPriceKid() {
        car.setPriceKid(25);
    }

    void buildPriceExempt() {
        car.setPriceExempt(20);
    }

    @Override
    void setNeedLicense() {
        car.needLicense = License.categoryD;
    }
}
