package No_1_200.No125验证回文串;

public class Solution {
    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String lowerCases = s.toLowerCase();
        char[] arr = lowerCases.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!isCharOrNum(arr[i])) {
                i++;
                continue;
            }
            if (!isCharOrNum(arr[j])) {
                j--;
                continue;
            }
            if (arr[i] != arr[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static boolean isCharOrNum(char c) {
        if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }
}
