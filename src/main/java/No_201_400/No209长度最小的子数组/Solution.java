package No_201_400.No209长度最小的子数组;

public class Solution {
    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minSubArrayLen(target, nums));
    }


    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) return 0;
        int minLen = Integer.MAX_VALUE;
        int sum = nums[0];
        int i = 0, j = 0;
        while (i <= j) {
            if (sum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i++];
            } else {
                if (j != nums.length - 1) sum += nums[++j];
                else break;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
