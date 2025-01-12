package No_201_400.No290单词规律;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MySolution {

    /**
     * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
     */
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat fish";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        char[] array = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (array.length != strings.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i], strings[i]);
            } else {
                if (!map.get(array[i]).equals(strings[i])) return false;
            }
        }
        return map.keySet().size() == new HashSet<>(map.values()).size();
    }

}
