package No_2501_3000.No2735收集巧克力;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {15, 150, 56, 69, 214, 203};
        int x = 42;
        System.out.println(minCost(nums, x));
    }

    public static long minCost(int[] nums, int x) {
        long totalCost = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[0] += nums[i];
        }

        for (int i = 1; i < n; i++) {

        }

        return totalCost;
    }
}
