package No_2501_3000.No2809使数组和小于等于x的最少时间;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(1, 2, 3);
        int x = 4;
        System.out.println(minimumTime(nums1, nums2, x));
    }


    public static int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int sum2=0;
        for (int i = 0; i < nums1.size(); i++) {
            sum2 += nums2.get(i);
        }
        int max1 = nums1.get(0);
        for (int i = 1; i < nums1.size(); i++) {
            max1 = Math.max(max1, nums1.get(i));
        }
        return 0;

    }
}
