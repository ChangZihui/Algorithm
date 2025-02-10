package No_1001_2000.No1630等差子数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 6, 5, 9, 3, 7}, l = {0, 0, 2}, r = {2, 3, 5};
        List<Boolean> booleans = checkArithmeticSubarrays(nums, l, r);
        for (Boolean aBoolean : booleans) {
            System.out.println(aBoolean);
        }
    }


    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < l.length && i < r.length; i++) {
            if (l[i] > r[i]) {
                list.add(false);
                continue;
            }
            if (l[i] == r[i]) {
                list.add(true);
                continue;
            }
            boolean flag = true;
            int[] ints = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(ints);
            for (int j = 1; j < ints.length; j++) {
                if ((ints[j] - ints[j - 1]) != (ints[1] - ints[0])) {
                    flag = false;
                    break;
                }
            }
            list.add(flag);
        }
        return list;
    }
}
