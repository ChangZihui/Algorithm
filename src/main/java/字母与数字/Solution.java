package 字母与数字;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
//        String[] s = {"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"};
        String[] s ={"A","A"};
        String[] longestSubarray = findLongestSubarray(s);
        System.out.println(Arrays.toString(longestSubarray));

    }

    public static String[] findLongestSubarray(String[] array) {
        int[] sub = new int[array.length + 1];
        sub[0] = 0;
        int a = 0, b = 0;
        for (int i = 1; i <= array.length; i++) {
            String s = array[i - 1];
            if (s.charAt(0) >= 48 && s.charAt(0) <= 57) {
                a++;
            } else {
                b++;
            }
            sub[i] = a - b;
        }
        int len = 0;
        int ind = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= array.length; i++) {
            Integer integer = map.get(sub[i]);
            if (integer != null) {
                if (i - integer > len) {
                    ind = integer;
                    len = i - integer;
                }
            } else {
                map.put(sub[i], i);
            }
        }
        if (ind != -1) {
            String[] strings = new String[len];
            System.arraycopy(array, ind, strings, 0, len);
            return strings;
        } else {
            return new String[0];
        }
    }
}
