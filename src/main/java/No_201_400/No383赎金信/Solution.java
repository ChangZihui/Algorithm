package No_201_400.No383赎金信;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] charArray = magazine.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] charArray1 = ransomNote.toCharArray();
        for (char c : charArray1) {
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                if (count - 1 < 0) return false;
                else map.put(c, count - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
