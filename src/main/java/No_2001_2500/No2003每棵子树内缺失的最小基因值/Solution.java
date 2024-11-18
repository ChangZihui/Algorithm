package No_2001_2500.No2003每棵子树内缺失的最小基因值;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] parents = {-1, 0, 0, 2};
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(smallestMissingValueSubtree(parents, nums)));
    }

    /**
     * 有一棵根节点为 0 的 家族树 ，总共包含 n 个节点，节点编号为 0 到 n - 1 。给你一个下标从 0 开始的整数数组
     * parents ，其中 parents[i] 是节点 i 的父节点。由于节点 0 是 根 ，所以 parents[0] == -1 。
     * 总共有 10^5 个基因值，每个基因值都用 闭区间 [1, 10^5] 中的一个整数表示。给你一个下标从 0 开始的整数数组 nums ，
     * 其中 nums[i] 是节点 i 的基因值，且基因值 互不相同 。
     * 请你返回一个数组 ans ，长度为 n ，其中 ans[i] 是以节点 i 为根的子树内 缺失 的 最小 基因值。
     * 节点 x 为根的 子树 包含节点 x 和它所有的 后代 节点。
     */
    public static int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        return null;
    }
}
