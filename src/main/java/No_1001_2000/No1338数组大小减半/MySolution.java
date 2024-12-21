package No_1001_2000.No1338数组大小减半;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySolution {

    /**
     * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
     * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
     * TODO 同官解
     * 是否存在时间复杂度为n的解法呢?
     */
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        System.out.println(minSetSize(arr));
    }

    /**
     * 贪心,从出现次数最多的整数开始删,直到次数之和大于n/2
     * 遍历,记录每个数字出现的次数
     * 排序,按次数高低排序
     * 求和,直到次数之和大于n/2
     * 时间复杂度nlogn
     * 空间复杂度n
     */
    public static int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        List<Integer> countList = countMap.values().stream().sorted(Collections.reverseOrder()).toList();

        int count = 0;
        for (int i = 0; i < countList.size(); i++) {
            count += countList.get(i);
            if (count >= n / 2) {
                return i + 1;
            }
        }
        return 0;
    }
}
