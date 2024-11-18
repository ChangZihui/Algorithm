package No_201_400.No381最大单次长度乘积;

import java.lang.invoke.VarHandle;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[] strings = {"eae", "ea", "aaf", "bda", "fcf", "dc", "ac", "ce", "cefde", "dabae"};
        System.out.println(maxProduct(strings));
    }

    public static int maxProduct(String[] words) {
        Arrays.sort(words, (o1, o2) -> {
                    int len1 = o1.length();
                    int len2 = o2.length();
                    if (len1 == len2) {
                        return o1.compareTo(o2);
                    }
                    return len2 - len1;
                });
        int[][] ints = new int[words.length][words.length];
        int max = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < i; j++) {
                ints[i][j] = words[i].length() * words[j].length();
                Set<Character> set = new HashSet<>();
                for (char c : words[i].toCharArray()) {
                    set.add(c);
                }
                int m = set.size();
                Set<Character> set1 = new HashSet<>();
                for (char c : words[j].toCharArray()) {
                    set1.add(c);
                }
                int n = set1.size();
                set1.addAll(set);
                if (set1.size() == m + n) {
                    max = Math.max(max, ints[i][j]);
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
