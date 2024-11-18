package No_2001_2500.No2342数位和相等数对的最大和;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {10,12,19,14};
        System.out.println(maximumSum(nums));
    }

    public static int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int sum = sums(num);
            List<Integer> integers = map.get(sum);
            if (integers == null) {
                integers = new ArrayList<>();
                integers.add(num);
                map.put(sum, integers);
            } else {
                if (integers.size() == 1) {
                    integers.add(num);
                } else if (integers.size() == 2) {
                    int[] sort = sort(num, integers.get(0), integers.get(1));
                    integers.set(0, sort[1]);
                    integers.set(1, sort[2]);
                }
            }
        }
        int sum = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() == 2) {
                sum = Math.max(sum, list.get(0) + list.get(1));
            }
        }
        return sum;
    }

    public static int sums(int a) {
        String[] split = (a + "").split("");
        int sum = 0;
        for (String s : split) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    public static int[] sort(int a, int b, int c) {
        int[] ints = {a, b, c};
        Arrays.sort(ints);
        return ints;
    }
}
