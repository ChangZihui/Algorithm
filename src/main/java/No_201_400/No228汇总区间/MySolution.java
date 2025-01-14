package No_201_400.No228汇总区间;

import java.util.ArrayList;
import java.util.List;

public class MySolution {
    /**
     * 给定一个  无重复元素 的 有序 整数数组 nums 。
     * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
     * 并且不存在属于某个范围但不属于 nums 的数字 x 。
     * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
     * "a->b" ，如果 a != b
     * "a" ，如果 a == b
     */
    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 4, 5, 7};
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        String cur = nums[0] + "";
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != start + 1) {
                if (cur.equals(start + "")) {
                    res.add(cur);
                } else {
                    res.add(cur + "->" + start);
                }
                cur = nums[i] + "";
            }
            start = nums[i];
        }
        if (cur.equals(start + "")) {
            res.add(cur);
        } else {
            res.add(cur + "->" + start);
        }

        return res;
    }
}
