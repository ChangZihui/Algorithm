package No_3000Plus.No3066超过阈值的最少操作数II;

public class MySolution {

    /**
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
     * 一次操作中，你将执行：
     * 选择 nums 中最小的两个整数 x 和 y 。
     * 将 x 和 y 从 nums 中删除。
     * 将 min(x, y) * 2 + max(x, y) 添加到数组中的任意位置。
     * 注意，只有当 nums 至少包含两个元素时，你才可以执行以上操作。
     * 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
     * TODO :使用小根堆来减少排序的复杂度
     */
    public static void main(String[] args) {
//        int[] nums = {999999999, 999999999, 999999999};
        int[] nums = {2, 11, 10, 1, 3};
//        int[] nums = {1, 1, 2, 4, 9};
//        int[] nums = {69, 89, 57, 31, 84, 97, 50, 38, 91, 86};
        int k = 10;
        System.out.println(minOperations(nums, k));
    }


    public static int minOperations(int[] nums, int k) {
        int result = 0;
        int max = 0;
        for (int num : nums) {
            if (num < k) max++;
        }
        while (max > 0) {
            int min1, min2;
            if (nums[0] > nums[1]) {
                min1 = 1;
                min2 = 0;
            } else {
                min1 = 0;
                min2 = 1;
            }
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] < nums[min1]) {
                    min2 = min1;
                    min1 = i;
                } else if (nums[i] < nums[min2]) {
                    min2 = i;
                }
            }
            long i = nums[min1] * 2L + nums[min2];
            if (i >= k) {
                nums[min1] = k;
                max--;
            } else {
                nums[min1] = (int) i;
            }
            nums[min2] = k;
            max--;
            result++;
        }
        return result;
    }
}
