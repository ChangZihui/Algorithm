package No_2001_2500.No2216美化数组的最少删除数;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3};
        System.out.println(minDeletion(nums));
    }

    public static int minDeletion(int[] nums) {
        int del = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                del++;
                continue;
            }
            if (nums[i] != nums[i + 1]) {
                i++;
            } else {
                del++;
            }
        }
        return del;
    }
}
