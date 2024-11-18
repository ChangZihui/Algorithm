package No_1_200.No45跳跃游戏II;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int res = 0;
        int curIndex = n - 1;
        while (curIndex > 0) {
            int step = 0;
            for (int i = 1; i <= curIndex; i++) {
                if (i <= nums[curIndex - i]) {
                    step=Math.max(step,i);
                }
            }
            curIndex -= step;
            res++;
        }
        return res;
    }
}

