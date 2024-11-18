package No_1_200.No134加油站;

public class Solution {
    public static void main(String[] args) {
        int[] gas = {2,3,4}, cost = {3,4,3};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] gap = new int[n];
        for (int i = 0; i < n; i++) {
            gap[i] = gas[i] - cost[i];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gap[i];
        }
        if (sum < 0) return -1;
        int start = -1;
        int curGas = 0;
        int step = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int index = i % n;
            if (start >= 0) {
                if (curGas + gap[index] < 0) {
                    //无法继续行驶到下一个加油站
                    start = -1;
                    curGas = 0;
                }
                if (curGas + gap[index] >= 0) {
                    curGas += gap[index];
                }
            } else {
                if (gap[i] >= 0) {
                    start = i;
                    curGas += gap[i];
                }
            }
        }
        return start;
    }
}
