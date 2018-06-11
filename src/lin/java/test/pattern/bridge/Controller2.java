package lin.java.test.pattern.bridge;

public class Controller2 extends RemoteController {

    public Controller2(TV tv) {
        super(tv);
    }

    @Override
    public void on() {
        System.out.println("Controller2 on");
        tv.on();
    }

    @Override
    public void off() {
        System.out.println("Controller2 off");
        tv.off();
    }

    @Override
    public void tuneChannel() {
        System.out.println("Controller2 tuneChannel");
        tv.tuneChannel();
    }
}
