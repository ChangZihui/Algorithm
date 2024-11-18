package No_201_400.No365水壶问题;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3;
        System.out.println(canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity));
    }


    public static boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        int maxCapacity = Math.max(jug1Capacity, jug2Capacity);
        int minCapacity = Math.min(jug1Capacity, jug2Capacity);
        Map<Integer, Integer> map = new HashMap<>();
        if (targetCapacity > maxCapacity + minCapacity) return false;
        map.put(maxCapacity + minCapacity, 1);
        map.put(0, 1);
        int usedCapacity2 = 0;
        while (true) {
            if (minCapacity + usedCapacity2 > maxCapacity) {
                usedCapacity2 = minCapacity + usedCapacity2 - maxCapacity;
                map.put(usedCapacity2 + maxCapacity, 1);
                if (Integer.valueOf(1).equals(map.get(usedCapacity2))) break;
            } else {
                usedCapacity2 += minCapacity;
            }
            map.put(usedCapacity2, 1);
        }
        return Integer.valueOf(1).equals(map.get(targetCapacity));
    }
}
