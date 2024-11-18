package No_2501_3000.No2736最大和查询;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 5}, nums2 = {2, 3, 4};
//        int[][] queries = {{4, 1}, {1, 3}, {2, 5}};'
        int[][] queries = {{4, 4}, {3, 2}, {1, 1}};
        System.out.println(Arrays.toString(maximumSumQueries(nums1, nums2, queries)));
    }

    public static int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int[] answer = new int[queries.length];
        int n = nums1.length;
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) sum[i] = nums1[i] + nums2[i];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int max = -1;
            for (int j = 0; j < n; j++) {
                if (nums1[j] >= query[0] && nums2[j] >= query[1]) max = Math.max(max, sum[j]);
            }
            answer[i] = max;
        }
        return answer;
    }
}
