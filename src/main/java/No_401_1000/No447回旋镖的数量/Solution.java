package No_401_1000.No447回旋镖的数量;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if (n < 3) return 0;
        AtomicInteger result = new AtomicInteger();
        for (int[] pi : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] pj : points) {
                int dis = (pi[0] - pj[0]) * (pi[0] - pj[0]) + (pi[1] - pj[1]) * (pi[1] - pj[1]);
                if (map.containsKey(dis)) {
                    map.put(dis, map.get(dis) + 1);
                } else {
                    map.put(dis, 1);
                }
            }
            map.forEach((k, v) -> result.addAndGet(v * (v - 1)));

        }

        return result.get();
    }
}
