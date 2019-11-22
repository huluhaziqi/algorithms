package com.huluhaziqi.algorithms.pattern.bridge;

public abstract class RemoteController {

    protected TV tv;

    public RemoteController(TV tv) {
        this.tv = tv;
    }

    public abstract void on();

    public abstract void off();

    public abstract void tuneChannel();
}
