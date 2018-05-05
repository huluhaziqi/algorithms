package lin.java.test.dynamic_programming;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new ClimbingStairs().climbStairs(n));
    }

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre = 1;
        int cur = 2;
        int result = 0;
        for (int j = 3; j <= n; j++) {
            result = pre + cur;
            pre = cur;
            cur = result;
        }
        return result;
    }
}
