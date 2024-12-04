package No_401_1000.No628三个数的最大乘积;

import java.util.Arrays;

public class Solution {

    /**
     * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     */
    public static void main(String[] args) {
        int[] nums={-5,1,2,6,30};
        System.out.println(cal(nums));
    }


    public static int cal(int[] nums) {
        int n=nums.length;
        if (nums.length<3) return 0;
        Arrays.sort(nums);
        //如果第一位大于0，则返回最大的三个数的乘积
        if (nums[0]>0){
            return nums[n-1]*nums[n-2]*nums[n-3];
        }
        //如果最后一位小于0，则返回绝对值最小的三个数的乘积
        if (nums[n-1]<0){
            return nums[n-1]*nums[n-2]*nums[n-3];
        }
        int a=nums[0]*nums[1]*nums[n-1];
        int b=nums[n-1]*nums[n-2]*nums[n-3];

        return Math.max(a,b);
    }
}
