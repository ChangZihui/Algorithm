package No_201_400.No205同构字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MySolution {

    /**
     * 给定两个字符串 s 和 t ，判断它们是否是同构的。
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
     * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     */
    public static void main(String[] args) {
        String s = "badc", t = "baba";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
            }
        }
        return map.keySet().size()==new HashSet<>(map.values()).size();
    }
}
