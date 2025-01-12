package No_2001_2500.No2275按位与结果大于零的最长组合;

public class MySolution {

    /**
     * 对数组 nums 执行 按位与 相当于对数组 nums 中的所有整数执行 按位与 。
     * 例如，对 nums = [1, 5, 3] 来说，按位与等于 1 & 5 & 3 = 1 。
     * 同样，对 nums = [7] 而言，按位与等于 7 。
     * 给你一个正整数数组 candidates 。计算 candidates 中的数字每种组合下 按位与 的结果。
     * 返回按位与结果大于 0 的 最长 组合的长度。
     * TODO 同官解
     */
    public static void main(String[] args) {
        int[] candidates = {16, 17, 71, 62, 12, 24, 14};
        System.out.println(largestCombination(candidates));
    }

    /**
     * 将所有数转换为二进制,看做一个由01组成的矩阵
     * 按位与的结果取决于每一列1和0的分布情况
     * 取1最多的一列即可
     */
    public static int largestCombination(int[] candidates) {
        int result = 0;
        int max = 0;
        for (int candidate : candidates) {
            max=Math.max(candidate,max);
        }
        int n = 0;
        while (max >> n > 0) n++;
        // TODO 根据题目的数据范围,n其实可以为常数
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int candidate : candidates) {
                if ((candidate >> i) % 2 == 1) count++;
            }
            result = Math.max(count, result);
        }
        return result;
    }
}
