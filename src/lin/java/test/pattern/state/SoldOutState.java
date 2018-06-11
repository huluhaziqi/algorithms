package lin.java.test.pattern.state;

public class SoldOutState implements State {

    GumballMachine gumballMachine ;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you can not insert a coin ,the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("you can not eject .you haven't inserted a quater yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned ,but there are not gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("no gumball dispensed");
    }
}
