package lin.java.test.algorithms.dynamic_programming;

public class IntegerBreak {

    public static void main(String[] args) {
        int n = 4;
        int reuslt = new IntegerBreak().integerBreak(n);
        System.out.println(reuslt);
    }

    public int integerBreak(int n) {
        if(n <= 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i],Math.max(dp[j] * (i - j),(i - j) * j));
            }
        }
        return dp[n];
    }
}
