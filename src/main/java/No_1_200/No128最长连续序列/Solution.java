package No_1_200.No128最长连续序列;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }
        int maxLength = 0;
        for (Integer i : map.keySet()) {
            if (map.get(i) == 0) continue;
            int length = 1;
            int start = i - 1, end = i + 1;
            map.put(i, 0);
            while (map.get(start) != null || map.get(end) != null) {
                if (map.get(start) != null) {
                    map.put(start--, 0);
                }
                if (map.get(end) != null) {
                    map.put(end++, 0);
                }
            }
            length = end - start - 1;
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
}
