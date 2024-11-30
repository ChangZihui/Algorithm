package No_3000Plus.No3232判断是否可以赢得数字游戏;

public class MySolution {

    /**
     * 给你一个 正整数 数组 nums。
     * Alice 和 Bob 正在玩游戏。在游戏中，Alice 可以从 nums 中选择所有个位数 或 所有两位数，剩余的数字归 Bob 所有。
     * 如果 Alice 所选数字之和 严格大于 Bob 的数字之和，则 Alice 获胜。
     * 如果 Alice 能赢得这场游戏，返回 true；否则，返回 false。
     * 1 <= nums.length <= 100
     * 1 <= nums[i] <= 99
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,10};
        System.out.println(canAliceWin(nums));
    }

    /**
     * 遍历数组,记录个位数之和和两位数之和
     */
    public static boolean canAliceWin(int[] nums) {
        int split = 10;
        int sum1 = 0, sum2 = 0;
        for (int num : nums) {
            if (num < split) {
                sum1 += num;
            } else {
                sum2 += num;
            }
        }
        return sum1 != sum2;
    }

}
