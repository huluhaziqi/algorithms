package lin.java.test.algorithms.bitcount;

public class BitCount {

    class Solution {
        public int hammingDistance(int x, int y) {
            int tem = (x ^ y);
            System.out.print(tem);
            int len = 0;
            while(tem > 0){
                tem = tem & (tem - 1);
                len++;
            }
            return len;
        }

        public int hammingDistance2(int x, int y) {
            int tem = (x ^ y);
            System.out.print(tem);
            int len = 0;
            while(tem > 0){
                if((tem & 1) == 1) len++;
                tem >>= 1;
            }
            return len;
        }

    }
}
