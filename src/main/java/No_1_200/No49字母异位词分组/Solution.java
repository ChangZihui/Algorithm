package No_1_200.No49字母异位词分组;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list.toString());
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            boolean exist = false;
            for (Map<Character, Integer> key : map.keySet()) {
                if (isAnagrams(str, key)) {
                    map.get(key).add(str);
                    exist = true;
                }
            }
            if (!exist) {
                List<String> list = new ArrayList<>();
                list.add(str);
                Map<Character, Integer> charactorMap = new HashMap<>();
                for (char c : str.toCharArray()) {
                    charactorMap.merge(c, 1, Integer::sum);
                }
                map.put(charactorMap, list);
            }
        }
        for (Map.Entry<Map<Character, Integer>, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static boolean isAnagrams(String str, Map<Character, Integer> map) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : str.toCharArray()) {
            map1.merge(c, 1, Integer::sum);
        }
        for (Character c : map.keySet()) {
            Integer count = map.get(c);
            Integer count1 = map1.get(c);
            if (count != count1) {
                return false;
            } else {
                map1.remove(c);
            }
        }
        return map1.isEmpty();
    }
}

