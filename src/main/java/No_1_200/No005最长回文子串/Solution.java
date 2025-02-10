package No_1_200.No005最长回文子串;

public class Solution {
    public static void main(String[] args) {
        String s = "bb";
        System.out.println(longestPalindrome(s));
    }


    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int maxlen = 1;
        int begin = 0;
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n; i++) {
                int j = i + L - 1;
                if (j >= n) {
                    break;
                }
                if (chars[i] == chars[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i + 1 > maxlen) {
                    maxlen = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }
}