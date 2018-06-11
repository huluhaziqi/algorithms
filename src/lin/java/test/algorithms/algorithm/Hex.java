package lin.java.test.algorithms.algorithm;

public class Hex {

    public static void main(String[] args) {
        toHex(-1);
    }

    static char[] a = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public static String toHex(int num) {
        if(num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            sb.append(a[num & 0b1111]);
            num >>>= 4;
        }
        String ret = sb.reverse().toString();
        return ret;
    }
}
