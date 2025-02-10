package No_2001_2500.No2389和有限的最长子序列;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1}, queries = {1,3};
        System.out.println(Arrays.toString(answerQueries(nums, queries)));

    }

    public static int[] answerQueries(int[] nums, int[] queries) {
            int[] ints = new int[queries.length];
            int[] sums = new int[nums.length];
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sums[i] = sum;
            }
            for (int i = 0; i < queries.length; i++) {
                int query = queries[i];
                int s = Arrays.binarySearch(sums, query);
                ints[i]=s>=0?s+1:-s-1;
            }
            return ints;
    }


}
