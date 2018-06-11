package lin.java.test.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Weather implements Subject {

    private List<Observer> observers;

    private int temperature;

    private int humidity;

    private int pressure;

    public Weather() {
        observers = new ArrayList<>();
    }

    public void setMeasurements(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
    }

    @Override
    public void resisterObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObServer(Observer o) {
        int index = observers.indexOf(o);
        if (index > 0) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(temperature, (humidity), pressure);
        }
    }
}
