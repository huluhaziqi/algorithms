package com.huluhaziqi.algorithms.pattern.command;

public class Client {
    //将命令封装成对象中，以便使用命令来参数化其它对象，
    // 或者将命令对象放入队列中进行排队，
    // 或者将命令对象的操作记录到日志中，
    // 以及支持可撤销的操作。
    public static void main(String[] args) {
        Light light = new Light();

        Invoker invoker = new Invoker();

        Command onCommand = new LightOnCommand(light);

        Command offCommand = new LightOffCommand(light);

        invoker.setOnCommand(onCommand,0);
        invoker.setOffCommand(offCommand,0);

        invoker.onButtonPush(0);
        invoker.offButtonPush(0);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

    }
}
