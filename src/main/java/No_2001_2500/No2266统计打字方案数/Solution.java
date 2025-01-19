package No_2001_2500.No2266统计打字方案数;

public class Solution {

    public int countTexts(String pressedKeys) {
        int len = pressedKeys.length();
        int[] dp = new int[len + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 1; i <= len; i++) {
            char c = pressedKeys.charAt(i - 1);
            dp[i] = dp[i - 1];
            for (int j = 2; j <= ((c == '7' || c == '9') ? 4 : 3) && j <= i; j++) {
                int index = i - j;
                if (c != pressedKeys.charAt(index)) {
                    break;
                }
                dp[i] = (dp[i] + dp[index]) % 1000000007;
            }
        }
        return dp[len];
    }
}
