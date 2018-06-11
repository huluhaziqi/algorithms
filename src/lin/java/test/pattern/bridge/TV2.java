package lin.java.test.pattern.bridge;

public class TV2 extends TV {
    @Override
    public void on() {
        System.out.println("tv2 on");

    }

    @Override
    public void off() {
        System.out.println("tv2 OFF");

    }

    @Override
    public void tuneChannel() {
        System.out.println("tv2 tuneChannel");

    }
}
