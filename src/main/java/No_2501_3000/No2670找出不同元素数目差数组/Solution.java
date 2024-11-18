package No_2501_3000.No2670找出不同元素数目差数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(distinctDifferenceArray(nums)));
    }

    public static int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n + 1];
        Set<Integer> preSet = new HashSet<>();
        Set<Integer> sufSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!preSet.contains(nums[i])) {
                preSet.add(nums[i]);
            }
            pre[i] = preSet.size();
            if (!sufSet.contains(nums[n - 1 - i])) {
                sufSet.add(nums[n - 1 - i]);
            }
            suf[n - 1 - i] = sufSet.size();
        }
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = pre[i] - suf[i + 1];
        }
        return diff;
    }
}
