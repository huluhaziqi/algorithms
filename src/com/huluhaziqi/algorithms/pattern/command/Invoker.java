package com.huluhaziqi.algorithms.pattern.command;

public class Invoker {

    private Command[] onCommand;

    private Command[] offCommand;

    private final int num = 7;

    public Invoker() {
        onCommand = new Command[num];
        offCommand = new Command[num];
    }

    public void setOnCommand(Command onCommand, int c) {
        this.onCommand[c] = onCommand;
    }

    public void setOffCommand(Command offCommand,int c) {
        this.offCommand[c] = offCommand;
    }

    public void onButtonPush(int c){
        onCommand[c].execute();
    }

    public void offButtonPush(int c){
        offCommand[c].execute();
    }
}
