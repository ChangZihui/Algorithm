package No_2501_3000.No2673使二叉树所有路径值相等的最小代价;

public class Solution {

    private static Integer count = 0;


    public static void main(String[] args) {
        int n = 7;
        int[] costs = {1, 5, 2, 2, 3, 3, 1};
        System.out.println(minIncrements(n, costs));

    }

    public static int minIncrements(int n, int[] cost) {
        count=0;
        int[] calcCost = new int[(n + 1) / 2];
        int maxCost = Integer.MIN_VALUE;
        for (int i = 0; i < calcCost.length; i++) {
            int costi = 0;
            int index = i + (n + 1) / 2;
            while (index > 0) {
                costi += cost[index - 1];
                index = index / 2;
            }
            calcCost[i] = costi;
            maxCost = Math.max(maxCost, costi);
        }
        mod(calcCost, 0, calcCost.length - 1, maxCost);
        return count;
    }

    public static void mod(int[] nums, int from, int to, int maxCost) {
        int partMax = maxOfArray(nums, from, to);
        for (int i = from; i <= to; i++) {
            nums[i] += (maxCost - partMax);
        }
        count += maxCost - partMax;
        if (from == to) {
            return;
        }
        mod(nums, from, (from + to) / 2, maxCost);
        mod(nums, (from + to) / 2 + 1, to, maxCost);
    }

    public static int maxOfArray(int[] nums, int from, int to) {
        int max = Integer.MIN_VALUE;
        for (int i = from; i <= to; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
