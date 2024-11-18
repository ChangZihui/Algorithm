package No_1_200.No78子集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset.toString());
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Integer[] nums1 =new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
        Arrays.sort(nums1, (o1, o2) -> o2-o1);
        return new ArrayList<>(subset(nums1, 0));
    }

    public static List<List<Integer>> subset(Integer[] nums, int fromIndex) {
        List<List<Integer>> integers = new ArrayList<>();
        if (fromIndex == nums.length) {
            integers.add(new ArrayList<>());
            return integers;
        }
        List<List<Integer>> lists = new ArrayList<>(subset(nums, fromIndex + 1));
        integers.addAll(lists);
        for (List<Integer> list : lists) {
            List<Integer> cp = new ArrayList<>(List.copyOf(list));
            cp.add(nums[fromIndex]);
            integers.add(cp);
        }
        return integers;
    }

}
