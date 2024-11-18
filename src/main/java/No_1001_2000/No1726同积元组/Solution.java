package No_1001_2000.No1726同积元组;

import javax.management.MXBean;
import java.security.Key;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {20,10,6,24,15,5,4,30};//4,5,6,10,15,20,24,30
        //4,6,20,30;4,5,24,30;5,6,20,24;5,10,15,30;
        System.out.println(tupleSameProduct(nums));
    }

    public static int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        Set<String> set = new HashSet<>();
        List<Integer> collect = Arrays.stream(nums).boxed().toList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = 2; nums[j] * k <= max; k++) {
                    int a = collect.indexOf(k * nums[i]);
                    int b = collect.indexOf(k * nums[j]);
                    if (a == -1 || b == -1) continue;
                    if (a != j) {
                        int[] r = new int[]{nums[i], nums[j], nums[a], nums[b]};
                        Arrays.sort(r);
                        set.add(Arrays.toString(r));
                    }
                }
            }
        }
        return set.size()*8;

    }
}
