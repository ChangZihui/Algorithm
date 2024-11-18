package No_2501_3000.No2646最小化旅行的价格总和;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int MaxValue = 100000;
    public static int[][] path;

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}}, trips = {{0, 3}, {2, 1}, {2, 3}};
        int[] price = {2, 2, 10, 6};
        System.out.println(minimumTotalPrice(n, edges, price, trips));
    }

    public static int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        int[][] costs = new int[n][n];
        path = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costs[i][j] = i == j ? price[i] : MaxValue;
            }
        }
        int[][] connect = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            costs[edge[0]][edge[1]] = costs[edge[1]][edge[0]] = price[edge[0]] + price[edge[1]];
            connect[edge[0]][edge[1]] = connect[edge[1]][edge[0]] = 1;
        }

        Map<Integer, Integer> path = new HashMap<>();
        for (int i = 0; i < n; i++) {
            path.put(i, 0);
        }

        int sum = floyd(costs, price, path, trips);
        for (int i = 0; i < n; i++) {
            int[] ints =new int[n];


        }

        return sum;
    }


    //非递归实现
    public static int floyd(int[][] matrix, int[] price, Map<Integer, Integer> map, int[][] trips) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                path[i][j] = -1;
            }
        }

        for (int m = 0; m < matrix.length; m++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    int cost = matrix[i][m] + matrix[m][j] - price[m];
                    if (cost < matrix[i][j]) {
                        matrix[i][j] = cost;
                        //记录经由哪个点到达
                        path[i][j] = m;
                    }
                }
            }
        }
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            int j = trip[0], k = trip[1];
            if (j != k) {
                if (matrix[i][j] == MaxValue) {
                    System.out.println(j + "到" + k + "不可达");
                } else {
                    System.out.print(j + "到" + k + "的最短路径长度是：" + matrix[i][j]);
                    System.out.print("最短路径为：" + j + "->");
                    sum += matrix[i][j];
                    map.put(j, (map.get(j) + 1) * price[j] / 2);
                    findPath(j, k, map, price);
                    System.out.println(k);
                    map.put(k, (map.get(k) + 1) * price[k] / 2);
                }
            }
        }
        return sum;
    }

    //递归寻找路径
    public static void findPath(int i, int j, Map<Integer, Integer> map, int[] price) {
        int m = path[i][j];
        if (m == -1) {
            return;
        }
        findPath(i, m, map, price);
        map.put(m, (map.get(m) + 1) * price[m] / 2);
        System.out.print(m + "->");
        findPath(m, j, map, price);
    }
}
