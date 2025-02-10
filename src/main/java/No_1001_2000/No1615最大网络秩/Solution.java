package No_1001_2000.No1615最大网络秩;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 8;
        int[][] roads = {{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}};
        System.out.println(maximalNetworkRank(n, roads));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        int max = 0;
        int[][] ints = new int[n][n];
        //初始化为0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = 0;
            }
        }
        for (int[] road : roads) {
            ints[road[0]][road[1]] = 1;
            ints[road[1]][road[0]] = 1;
        }
        //行和
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            row[i] = Arrays.stream(ints[i]).sum();
        }
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                c += ints[j][i];
            }
            col[i] = c;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int sum = row[i] + col[j] - ints[i][j];
                    max = Math.max(sum, max);
                }
            }
        }
        return max;
    }

}
