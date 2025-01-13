package No_2001_2500.No2270分割数组的方案数;

public class MySolution {
    /**
     * 给你一个下标从 0 开始长度为 n 的整数数组 nums 。
     * 如果以下描述为真，那么 nums 在下标 i 处有一个 合法的分割 ：
     * 前 i + 1 个元素的和 大于等于 剩下的 n - i - 1 个元素的和。
     * 下标 i 的右边 至少有一个 元素，也就是说下标 i 满足 0 <= i < n - 1 。
     * 请你返回 nums 中的 合法分割 方案数。
     */
    public static void main(String[] args) {
//        int[] nums = {10, 4, -8, 7};
        int[] nums = {2, 3, 1, 0};
        System.out.println(waysToSplitArray(nums));
    }

    public static int waysToSplitArray(int[] nums) {
        long suml = 0, sumr = 0;
        for (int num : nums) {
            sumr += num;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            suml += nums[i];
            sumr -= nums[i];
            if (suml >= sumr) count++;
        }
        return count;
    }
}
