package No_1001_2000.No1334阈值距离内邻居最少的城市;

import java.lang.annotation.ElementType;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 8, distanceThreshold = 7937;
        int[][] edges = {{3, 5, 9558}, {1, 2, 1079}, {1, 3, 8040}, {0, 1, 9258}, {4, 7, 7558}, {5, 6, 8196}, {3, 4, 7284}, {1, 5, 6327},
                {0, 4, 5966}, {3, 6, 8575}, {2, 5, 8604}, {1, 7, 7782}, {4, 6, 2857}, {3, 7, 2336}, {0, 6, 6}, {5, 7, 2870}, {4, 5, 5055},
                {0, 7, 2904}, {1, 6, 2458}, {0, 5, 3399}, {6, 7, 2202}, {0, 2, 3996}, {0, 3, 7495}, {1, 4, 2262}, {2, 6, 1390}};
//        int n = 4, edges[][] = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, distanceThreshold = 4;
//        int n = 5, edges[][] = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, distanceThreshold = 2;
        System.out.println(findTheCity(n, edges, distanceThreshold));

    }
//    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
//        int[] ans = {Integer.MAX_VALUE / 2, -1};
//        int[][] mp = new int[n][n];
//        for (int i = 0; i < n; ++i) {
//            Arrays.fill(mp[i], Integer.MAX_VALUE / 2);
//        }
//        for (int[] eg : edges) {
//            int from = eg[0], to = eg[1], weight = eg[2];
//            mp[from][to] = mp[to][from] = weight;
//        }
//        for (int k = 0; k < n; ++k) {
//            mp[k][k] = 0;
//            for (int i = 0; i < n; ++i) {
//                for (int j = 0; j < n; ++j) {
//                    mp[i][j] = Math.min(mp[i][j], mp[i][k] + mp[k][j]);
//                }
//            }
//        }
//        for (int i = 0; i < n; ++i) {
//            int cnt = 0;
//            for (int j = 0; j < n; ++j) {
//                if (mp[i][j] <= distanceThreshold) {
//                    cnt++;
//                }
//            }
//            if (cnt <= ans[0]) {
//                ans[0] = cnt;
//                ans[1] = i;
//            }
//        }
//        return ans[1];
//    }


    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //邻接矩阵，复杂度n^3
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0; //自身到自身的距离为0
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n ; k++) {
                    matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
                }
            }
        }


        int s = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= distanceThreshold) {
                    sum++;
                }
            }
            if (sum <= s) {
                s = sum;
                max = i;
            }
        }
        return max;
    }
}
