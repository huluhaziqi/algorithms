package lin.java.test.pattern.observer;

public class Client {

    public static void main(String[] args) {
        Weather weather = new Weather();
        Observer observer1 = new AObserver(weather);
        Observer observer2 = new AObserver(weather);
        Observer observer3 = new ConcreteObsrever(weather);

        weather.setMeasurements(10,20,30);
        weather.setMeasurements(100,200,300);
    }
}
