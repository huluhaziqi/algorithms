package com.huluhaziqi.algorithms.pattern.facade;

public class Facade {

    private SubSystem subSystem = new SubSystem();

    public void watchMovie(){
        subSystem.turnOn();
        subSystem.startWatching();
        subSystem.turnoff();
    }
}
