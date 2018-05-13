package lin.java.test.algorithms.dynamic_programming;

public class DecodeWays {

    public static void main(String[] args) {
        String s = "12";
        DecodeWays decodeWays = new DecodeWays();
        int result = decodeWays.numDecodings(s);

    }
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        char[] c = s.toCharArray();
        int len = c.length;
        int[] dp = new int[len + 1];
        if (s.length() == 1 && c[0] != '0') {
            return 1;
        }
        dp[0] = 1;
        for (int j = 1; j <= len; j++) {
            dp[j] = c[j] == '0' ? 0 : dp[j - 1];
            if (j > 1 && (c[j - 2] == '1' || (c[j - 2] == '2' && c[j - 1] <= '6'))) {
                dp[j] += dp[j - 2];
            }
        }
        return dp[len];
    }
}
