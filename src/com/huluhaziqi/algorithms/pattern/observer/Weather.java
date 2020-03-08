package com.huluhaziqi.algorithms.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Weather implements Subject {

    List<Observer> observers;
    private int temperature;
    private int humidity;
    private int pressure;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public Weather() {
        this.observers = new ArrayList<>();
    }
    public Weather(List<Observer> observers) {
        this.observers = observers;
    }

    public void setMeasurements(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public Weather(List<Observer> observers, int temperature, int humidity, int pressure) {
        this.observers = observers;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}
