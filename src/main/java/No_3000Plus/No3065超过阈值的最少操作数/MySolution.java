package No_3000Plus.No3065超过阈值的最少操作数;

public class MySolution {
    /**
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
     * 一次操作中，你可以删除 nums 中的最小元素。
     * 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
     */
    public static void main(String[] args) {
        int[] nums = {2, 11, 10, 1, 3};
        int k = 10;
        System.out.println(minOperations(nums, k));
    }

    public static int minOperations(int[] nums, int k) {
        int result = 0;
        for (int num : nums) {
            if (num < k) result++;
        }
        return result;
    }
}
