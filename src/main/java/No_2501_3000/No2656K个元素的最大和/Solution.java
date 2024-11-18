package No_2501_3000.No2656K个元素的最大和;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5,5,5};
        int k = 2;
        System.out.println(maximizeSum(nums, k));
    }

    public static int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max * k + k * (k - 1) / 2;
    }
}
