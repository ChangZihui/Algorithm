package No_1001_2000.No1590使数组和能被P整除;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {19, 25, 39, 31, 20, 10, 40, 38, 28, 35, 11, 11, 18, 26, 26, 24, 29, 14, 10, 37};
        int p = 23;
        System.out.println(minSubarray(nums, p));
    }


    public static int minSubarray(int[] nums, int p) {
        int sum = 0;
        for (int num : nums) {
            sum += num % p;
        }
        int reg = sum % p;
        if (reg == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == reg) {
                return 1;
            }
            int subsum = 0;
            for (int j = i; j < nums.length; j++) {
                subsum += nums[j] % p;
                if (subsum % p == reg) {
                    if (j - i < min) {
                        min = j - i + 1;
                        break;
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE || min == nums.length) {
            return -1;
        } else {
            return min;
        }
    }
}
