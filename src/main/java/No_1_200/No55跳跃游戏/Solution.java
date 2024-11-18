package No_1_200.No55跳跃游戏;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int farthest = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (i == farthest && nums[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
