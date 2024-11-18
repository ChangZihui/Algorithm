package No_1_200.No3无重复字符的最长子串;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else {
                char c1 = s.charAt(i);
                if (c1 == c) j++;
                else set.remove(c1);
                i++;
            }
        }
        return maxLen;
    }

}
