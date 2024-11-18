package No_1001_2000.No1155投掷骰子等于目标和的方法数;

public class Solution {
    public static void main(String[] args) {
        int n = 30, k = 30, target = 500;
        System.out.println(numRollsToTarget(n, k, target));
    }

    public static long numRollsToTarget(int n, int k, int target) {
        long[][] ints = new long[n + 1][target+1];
        ints[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int l = 1; l <= k && j >= l; l++) {
                    ints[i][j] += ints[i - 1][j - l];
                }
                ints[i][j]=ints[i][j]%((int)Math.pow(10,9)+7);
            }
        }
        return (int)ints[n][target];
    }
}
