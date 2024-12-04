package No_1_200.No70爬楼梯;

public class Solution {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(test(n));

    }

    public static int test(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
