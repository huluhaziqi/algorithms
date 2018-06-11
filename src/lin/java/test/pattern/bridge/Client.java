package lin.java.test.pattern.bridge;

public class Client {
    public static void main(String[] args) {
        //将抽象和实现分离开来，将遥控器和电视分离开，可以单独改变遥控器或者电视的实现
        TV1 tv1 = new TV1();
        TV2 tv2 = new TV2();
        Controller1 controller1 = new Controller1(tv1);
        Controller2 controller2 = new Controller2(tv2);
        controller1.on();
        controller1.off();
        controller1.tuneChannel();
        controller2.on();
        controller2.off();
        controller2.tuneChannel();
    }
}
