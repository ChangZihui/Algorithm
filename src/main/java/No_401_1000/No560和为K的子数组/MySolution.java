package No_401_1000.No560和为K的子数组;

public class MySolution {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数
     * 子数组是数组中元素的连续非空序列
     */
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 1; i <= nums.length; i++) {
            int a = 0;
            int b = a + i - 1;
            int sum = 0;
            for (int j = a; j <= b; j++) {
                sum += nums[j];
            }
            while (true) {
                if (sum == k) result++;
                if (b == nums.length - 1) break;
                sum -= nums[a++];
                sum += nums[++b];
            }
        }

        return result;
    }
}
