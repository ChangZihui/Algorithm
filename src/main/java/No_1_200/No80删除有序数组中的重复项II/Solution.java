package No_1_200.No80删除有序数组中的重复项II;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));


    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int curComp = 0;
        int curMod = 1;
        int curTimes = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[curComp]) {
                curComp+=curTimes;
                nums[curMod++] = nums[i];
                curTimes = 1;
            } else {
                if (curTimes == 1) {
                    nums[curMod++]=nums[i];
                    curTimes++;
                }
            }
        }
        return curMod;
    }
}
