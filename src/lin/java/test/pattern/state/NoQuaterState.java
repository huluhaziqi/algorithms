package lin.java.test.pattern.state;

public class NoQuaterState implements State {

        GumballMachine gumballMachine ;

    public NoQuaterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you insert a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("you haven't insert a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("you turn ,there is no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("you need to pay first");
    }
}
