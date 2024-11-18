package No_1_200.No169多数元素;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }


    public static int majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer cnt = map.get(num);
            if (cnt == null) {
                cnt = 0;
            }
            map.put(num, cnt + 1);
            if (cnt + 1 > n / 2) return num;
        }
        return Integer.MAX_VALUE;
    }
}
