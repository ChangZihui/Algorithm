package No_2501_3000.No2760最长奇偶子数组;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,2,5,4};
        int threshold = 5;
        System.out.println(longestAlternatingSubarray(nums, threshold));
    }

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int max = 0;//最大子数组长度
        int len = 0;//当前子数组长度
        int before = 0;//标记前一位奇偶性，初始为偶数
        for (int i = 0; i < nums.length; i++) {
            if (len == 0) {
                if (nums[i] > threshold) continue;
                if (nums[i] % 2 == 0) {len++; before=0;}//长度为0，满足初始条件，开始计算长度
            } else {
                if (nums[i] <= threshold && (nums[i] % 2 ^ before) == 1) {
                    //当前位奇偶与前一位相反，长度+1 修改前一位标记
                    len++;
                    before = nums[i] % 2;
                } else {
                    //不满足条件-截取长度与最大值比较，重置长度
                    max = Math.max(len, max);
                    len = 0;
                    i--;
                }
            }
        }
        return Math.max(len, max);
    }
}
