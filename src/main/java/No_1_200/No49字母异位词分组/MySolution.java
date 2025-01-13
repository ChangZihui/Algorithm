package No_1_200.No49字母异位词分组;

import java.util.*;

public class MySolution {
    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     */
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        lists.forEach(System.out::println);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String string = Arrays.toString(count);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList<>());
            }
            map.getOrDefault(string, new ArrayList<>()).add(str);
        }
        return map.values().stream().toList();
    }
}
