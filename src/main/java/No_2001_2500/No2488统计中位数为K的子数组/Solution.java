package No_2001_2500.No2488统计中位数为K的子数组;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 5};
        int k = 4;
        System.out.println(countSubarrays(nums, k));

    }


    public static int countSubarrays(int[] nums, int k) {
        int max = 0;
        int index = Arrays.binarySearch(nums, k);
        int[] reg = new int[nums.length];
        reg[index] = 0;
        int big = 0;
        int small = 0;
        for (int i = 1; i <= index; i++) {
            if (nums[index - i] > k) {
                big++;
            } else {
                small++;
            }
            reg[index - i] = big - small;
        }
        big = 0;
        small = 0;
        for (int i = 1; i < nums.length - index; i++) {
            if (nums[index + i] > k) {
                big++;
            } else {
                small++;
            }
            reg[index + i] = big - small;
        }
        for (int j = 0; j <= index; j++) {
            for (int l = 0; l < nums.length - index; l++) {
                int i = reg[index - j] + reg[index + l];
                if (i == 0 || i == 1) max++;
            }
        }
        return max;
    }
}
