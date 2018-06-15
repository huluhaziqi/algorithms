package lin.java.test.algorithms.bitcount;

public class PowerOfFour {

    public static void main(String[] args) {
        new PowerOfFour().isPowerOfFour2(16);
    }

    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & (0b01010101010101010101010101010101)) != 0;
    }
    public boolean isPowerOfFour2(int num) {
        System.out.println(Integer.toString(num,4));
        return true;
    }
}
