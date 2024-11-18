package No_2501_3000.No2697字典序最小回文串;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String s = "seven";
        System.out.println(makeSmallestPalindrome(s));
    }


    public static String makeSmallestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        for (int i = 0; i < n / 2; i++) {
            if (charArray[i] < charArray[n - 1 - i]) {
                charArray[n - 1 - i] = charArray[i];
            } else {
                charArray[i] = charArray[n - 1 - i];
            }
        }

        return String.valueOf(charArray);
    }
}
