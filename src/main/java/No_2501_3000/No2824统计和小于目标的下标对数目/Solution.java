package No_2501_3000.No2824统计和小于目标的下标对数目;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, -6,2,5,-2,-7,-1,3);
        //-7-6,-2,-1,2,3,5
        int target = -2;
        System.out.println(countPairs(nums, target));
    }

    public static int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int count = 0, start = 0, end = nums.size() - 1;
        while (start < end) {
            int a = nums.get(start), b = nums.get(end);
            if (a + b < target) {
                count += (end - start);
                start++;
            }else {
                end--;
            }
        }
        return count;
    }
}
