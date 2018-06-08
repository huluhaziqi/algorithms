package lin.java.test.pattern.chainOfResponsibility;

public enum RequestTypeEnum {
    type1(1), type2(2);

    private byte value;

    RequestTypeEnum(int value) {
        this.value = (byte) value;
    }

    public int getValue() {
        return value;
    }
}
