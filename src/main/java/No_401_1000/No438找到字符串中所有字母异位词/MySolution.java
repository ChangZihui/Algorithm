package No_401_1000.No438找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySolution {
    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     */
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] chars = new int[26];
        int[] subChars = new int[26];
        for (int i = 0; i < p.length(); i++) {
            chars[p.charAt(i) - 'a']++;
            subChars[s.charAt(i) - 'a']++;
        }
        int i = 0, j = p.length() - 1;
        while (true) {
            if (Arrays.equals(chars, subChars)) result.add(i);
            if (j == s.length() - 1) break;
            subChars[s.charAt(i++) - 'a']--;
            subChars[s.charAt(++j) - 'a']++;
        }

        return result;
    }
}
