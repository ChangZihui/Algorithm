package No_1_200.No187重复的DNA序列;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        List<String> lis = findRepeatedDnaSequences(s);
        lis.forEach(System.out::println);
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            map.merge(substring, 1, Integer::sum);
        }
        return map.entrySet().stream().filter(e->e.getValue()>1).map(Map.Entry::getKey).toList();
    }
}
