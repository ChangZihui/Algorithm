package No_2501_3000.No2861最大合金数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int n = 3, k = 2, budget = 15;
        List<List<Integer>> composition = new ArrayList<>();
        List<Integer> composition1 = Arrays.asList(1, 1, 1);
        List<Integer> composition2 = Arrays.asList(1, 1, 10);
        composition.add(composition1);
        composition.add(composition2);
        List<Integer> stock = Arrays.asList(0, 0, 100);
        List<Integer> cost = Arrays.asList(1, 2, 3);
        System.out.println(maxNumberOfAlloys(n, k, budget, composition, stock, cost));
    }


    public static int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition,
                                        List<Integer> stock, List<Integer> cost) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            List<Integer> comp = composition.get(i);
            int cnt = 0;
            int costs = 0;
            while (budget - costs >= 0) {
                cnt++;
                costs = 0;
                for (int l = 0; l < n; l++) {
                    costs += comp.get(l) * cnt - stock.get(l) > 0 ? (comp.get(l) * cnt - stock.get(l)) * cost.get(l) : 0;
                }

            }
            max = Math.max(max, cnt-1);
        }
        return max;

    }
}
