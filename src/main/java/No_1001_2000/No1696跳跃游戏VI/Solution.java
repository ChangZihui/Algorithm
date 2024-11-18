package No_1001_2000.No1696跳跃游戏VI;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {10, -5, -2, 4, 1, 3};
        int k = 3;
        System.out.println(maxResult(nums, k));
    }

    public static int maxResult(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int index = 0, maxScore = nums[0];
        while (index != nums.length - 1) {
            int maxValue = Integer.MIN_VALUE, step = 0;
            for (int i = 1; i <= k && index + i < nums.length; i++) {
                if (maxValue < nums[index + i]) {
                    maxValue = nums[index + i];
                    step = i;
                }
                if (maxValue>0) break;
            }
            maxScore += maxValue;
            index += step;
        }
        return maxScore;
    }
}
