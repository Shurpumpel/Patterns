package com.company;

public interface Observed {
    void addObserver(Observer a);
    void removeObserver(Observer a);
    void notifyObserver();
}
