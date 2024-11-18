package No_2501_3000.No2586统计范围内的元音字符串数;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static List<Character> list = new ArrayList<>(List.of(new Character[]{'a', 'e', 'i', 'o', 'u'}));

    public static void main(String[] args) {
        String[] words = {"hey","aeo","mu","ooo","artro"};
        System.out.println(vowelStrings(words, 1, 4));
    }

    public static int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i < right + 1; i++) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            if (list.contains(start) && list.contains(end)) {
                count++;
            }
        }
        return count;
    }
}
