package No_2001_2500.No2316统计无向图中无法到达的点对数;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}};
//        int[][] edges = {{5, 0}, {1, 0}, {10, 7}, {9, 8}, {7, 2}, {1, 3}, {0, 2}, {8, 5}, {4, 6}, {4, 2}};
        System.out.println(countPairs(n, edges));

    }

    public static long countPairs(int n, int[][] edges) {
        long count = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> set = new ArrayList<>();
            set.add(i);
            list.add(set);
        }
        for (int[] edge : edges) {
            Integer i = edge[0], j = edge[1];
            List<Integer> a = null, b = null;
            for (List<Integer> set : list) {
                if (set.contains(i)) a = set;
                if (set.contains(j)) b = set;
            }
            if (a != b) {
                a.addAll(b);
                list.remove(b);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int size = list.get(i).size();
            count+= (long) size *(n-size);
        }
        return count/2;
    }
}