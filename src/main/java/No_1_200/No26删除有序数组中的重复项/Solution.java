package No_1_200.No26删除有序数组中的重复项;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(nums);
        System.out.println("剩余元素数量：" + i);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int curComp = 0;
        int curMod = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[curComp]) {
                curComp++;
                nums[curMod] = nums[i];
                curMod++;
            }
        }
        return curMod;
    }
}
