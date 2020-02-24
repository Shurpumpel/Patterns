package com.company;

public class TaxiBuilder extends TransportBuilder {
    @Override
    void buildMaxCountPassengers() {

    }

    @Override
    void buildPriceAdult() {
        car.setPriceAdult(100);
    }

    @Override
    void buildPriceKid() {
        car.setPriceKid(75);
    }

    @Override
    void buildPriceExempt() {    }

    @Override
    void setNeedLicense() {
        car.needLicense = License.categoryB;
    }
}
