package com.huluhaziqi.algorithms.pattern.observer;

public interface Subject {

    void resisterObserver(Observer o);

    void removeObServer(Observer o);

    void notifyObserver();
}