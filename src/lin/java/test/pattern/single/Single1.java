package lin.java.test.pattern.single;

public class Single1 {

    private final static Single1 single1;
    static
    {
        single1 = new Single1();
    }

    private Single1(){

    }

    public static Single1 getSingle1() {
        return single1;
    }
}
